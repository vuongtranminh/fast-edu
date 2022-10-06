package app.command.api.controller.impl;

import app.command.api.commands.CreateAccountCommand;
import app.command.api.commands.DeleteAccountCommand;
import app.command.api.commands.UpdateAccountCommand;
import app.command.api.controller.AccountCommandController;
import app.command.api.model.AccountRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountCommandControllerImpl implements AccountCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @Override
    @PostMapping
    public String save(AccountRequestModel model) {
        CreateAccountCommand command = CreateAccountCommand.builder()
                .id(model.getId())
                .username(model.getUsername())
                .password(model.getPassword())
                .build();
        commandGateway.sendAndWait(command);
        return "added Book";
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
    public String delete(Integer id) {
        commandGateway.sendAndWait(new DeleteAccountCommand(id));
        return "deleted book";
    }

}
