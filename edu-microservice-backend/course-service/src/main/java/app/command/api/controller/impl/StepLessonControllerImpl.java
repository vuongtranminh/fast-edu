package app.command.api.controller.impl;

import app.command.api.commands.CreateStepLessonCommand;
import app.command.api.commands.DeleteStepLessonCommand;
import app.command.api.commands.UpdateStepLessonCommand;
import app.command.api.controller.StepLessonController;
import app.command.api.model.StepLessonRequestModel;
import app.helper.StepLessonMappingHelper;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/steplessons")
public class StepLessonControllerImpl implements StepLessonController {

    private CommandGateway commandGateway;

    public StepLessonControllerImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    @PostMapping
    public String save(StepLessonRequestModel model) {
        CreateStepLessonCommand command = StepLessonMappingHelper.mapToCreateCommand(model);
        commandGateway.sendAndWait(command);
        return "add step lesson";
    }

    @Override
    @PutMapping
    public String update(StepLessonRequestModel model) {
        UpdateStepLessonCommand command = StepLessonMappingHelper.mapToUpdateCommand(model);
        commandGateway.sendAndWait(command);
        return "update step lesson";
    }

    @Override
    @DeleteMapping("/{id}")
    public String delete(String id) {
        DeleteStepLessonCommand command = new DeleteStepLessonCommand(id);
        commandGateway.sendAndWait(command);
        return "delete step lesson";
    }
}
