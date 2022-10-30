package app.command.api.controller.impl;

import app.command.api.commands.CreateStepChallengeCommand;
import app.command.api.commands.DeleteStepChallengeCommand;
import app.command.api.commands.UpdateStepChallengeCommand;
import app.command.api.controller.StepChallengeController;
import app.command.api.model.StepChallengeRequestModel;
import app.helper.StepChallengeMappingHelper;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/stepchallenges")
public class StepChallengeControllerImpl implements StepChallengeController {

    private CommandGateway commandGateway;

    public StepChallengeControllerImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    @PostMapping
    public String save(StepChallengeRequestModel model) {
        CreateStepChallengeCommand command = StepChallengeMappingHelper.mapToCreateCommand(model);
        commandGateway.sendAndWait(command);
        return "add step challenge";
    }

    @Override
    @PutMapping
    public String update(StepChallengeRequestModel model) {
        UpdateStepChallengeCommand command = StepChallengeMappingHelper.mapToUpdateCommand(model);
        commandGateway.sendAndWait(command);
        return "update step challenge";
    }

    @Override
    @DeleteMapping("/{id}")
    public String delete(String id) {
        DeleteStepChallengeCommand command = new DeleteStepChallengeCommand(id);
        commandGateway.sendAndWait(command);
        return "delete step challenge";
    }
}
