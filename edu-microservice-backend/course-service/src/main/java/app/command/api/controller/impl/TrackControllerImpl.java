package app.command.api.controller.impl;

import app.command.api.commands.CreateTrackCommand;
import app.command.api.commands.DeleteTrackCommand;
import app.command.api.commands.UpdateTrackCommand;
import app.command.api.controller.TrackController;
import app.command.api.model.TrackRequestModel;
import app.helper.TrackMappingHelper;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tracks")
public class TrackControllerImpl implements TrackController {

    private CommandGateway commandGateway;

    public TrackControllerImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    @PostMapping
    public String save(TrackRequestModel model) {
        CreateTrackCommand command = TrackMappingHelper.mapToCreateCommand(model);
        commandGateway.sendAndWait(command);
        return "add track";
    }

    @Override
    @PutMapping
    public String update(TrackRequestModel model) {
        UpdateTrackCommand command = TrackMappingHelper.mapToUpdateCommand(model);
        commandGateway.sendAndWait(command);
        return "update track";
    }

    @Override
    @DeleteMapping("/{id}")
    public String delete(String id) {
        DeleteTrackCommand command = new DeleteTrackCommand(id);
        commandGateway.sendAndWait(command);
        return "delete track";
    }
}
