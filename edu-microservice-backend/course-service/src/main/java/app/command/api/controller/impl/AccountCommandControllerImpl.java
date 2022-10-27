package app.command.api.controller.impl;

import app.command.api.controller.AccountCommandController;
import app.command.api.model.AccountRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountCommandControllerImpl implements AccountCommandController {

    private CommandGateway commandGateway;

    public AccountCommandControllerImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    @PostMapping
    public String save(AccountRequestModel model) {
        CreateAccountCommand command = CreateAccountCommand.builder()
                .username(model.getUsername())
                .password(model.getPassword())
                .build();
        commandGateway.sendAndWait(command);
        return "added Account";
    }

    @Override
    @PutMapping
    public String update(AccountRequestModel model) {
        UpdateAccountCommand command = UpdateAccountCommand.builder()
                .id(model.getId())
                .username(model.getUsername())
                .password(model.getPassword())
                .build();
        commandGateway.sendAndWait(command);
        return "updated book";
    }

    @Override
    @DeleteMapping("/{id}")
    public String delete(String id) {
        commandGateway.sendAndWait(new DeleteAccountCommand(id));
        return "deleted book";
    }

}
