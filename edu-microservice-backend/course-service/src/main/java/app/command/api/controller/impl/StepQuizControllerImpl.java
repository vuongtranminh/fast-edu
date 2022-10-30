package app.command.api.controller.impl;

import app.command.api.commands.CreateStepQuizCommand;
import app.command.api.commands.DeleteStepQuizCommand;
import app.command.api.commands.UpdateStepQuizCommand;
import app.command.api.controller.StepQuizController;
import app.command.api.model.StepQuizRequestModel;
import app.helper.StepQuizMappingHelper;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/stepquizs")
public class StepQuizControllerImpl implements StepQuizController {

    private CommandGateway commandGateway;

    public StepQuizControllerImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    @PostMapping
    public String save(StepQuizRequestModel model) {
        CreateStepQuizCommand command = StepQuizMappingHelper.mapToCreateCommand(model);
        commandGateway.sendAndWait(command);
        return "add step quiz";
    }

    @Override
    @PutMapping
    public String update(StepQuizRequestModel model) {
        UpdateStepQuizCommand command = StepQuizMappingHelper.mapToUpdateCommand(model);
        commandGateway.sendAndWait(command);
        return "update step quiz";
    }

    @Override
    @DeleteMapping("/{id}")
    public String delete(String id) {
        DeleteStepQuizCommand command = new DeleteStepQuizCommand(id);
        commandGateway.sendAndWait(command);
        return "delete step quiz";
    }
}
