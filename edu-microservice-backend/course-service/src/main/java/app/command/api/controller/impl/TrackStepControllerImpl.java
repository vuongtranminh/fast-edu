package app.command.api.controller.impl;

import app.command.api.commands.CreateTrackStepCommand;
import app.command.api.commands.DeleteTrackStepCommand;
import app.command.api.commands.UpdateTrackStepCommand;
import app.command.api.controller.TrackStepController;
import app.command.api.model.TrackStepRequestModel;
import app.helper.TrackStepMappingHelper;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tracksteps")
public class TrackStepControllerImpl implements TrackStepController {

    private CommandGateway commandGateway;

    public TrackStepControllerImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    @PostMapping
    public String save(TrackStepRequestModel model) {
        CreateTrackStepCommand command = TrackStepMappingHelper.mapToCreateCommand(model);
        commandGateway.sendAndWait(command);
        return "add track step";
    }

    @Override
    @PutMapping
    public String update(TrackStepRequestModel model) {
        UpdateTrackStepCommand command = TrackStepMappingHelper.mapToUpdateCommand(model);
        commandGateway.sendAndWait(command);
        return "update track step";
    }

    @Override
    @DeleteMapping("/{id}")
    public String delete(String id) {
        DeleteTrackStepCommand command = new DeleteTrackStepCommand(id);
        commandGateway.sendAndWait(command);
        return "delete track step";
    }
}
