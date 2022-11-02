package app.helper;

import app.command.api.commands.CreateStepQuizCommand;
import app.command.api.commands.CreateTrackCommand;
import app.command.api.commands.UpdateStepQuizCommand;
import app.command.api.commands.UpdateTrackCommand;
import app.command.api.model.StepQuizRequestModel;
import app.command.api.model.TrackRequestModel;

import java.util.Date;

public interface TrackMappingHelper {

    static CreateTrackCommand mapToCreateCommand(final TrackRequestModel model) {
        return CreateTrackCommand.builder()
                .duration(model.getDuration())
                .courseId(model.getCourseId())
                .updatedAt(model.getUpdatedAt())
                .isFree(model.getIsFree())
                .createdAt(model.getCreatedAt())
                .position(model.getPosition())
                .title(model.getTitle())
                .deletedAt(model.getDeletedAt())
                .isOptional(model.getIsOptional())
                .build();
    }

    static UpdateTrackCommand mapToUpdateCommand(final TrackRequestModel model) {
        return UpdateTrackCommand.builder()
                .id(model.getId())
                .courseId(model.getCourseId())
                .updatedAt(model.getUpdatedAt())
                .isFree(model.getIsFree())
                .createdAt(model.getCreatedAt())
                .position(model.getPosition())
                .title(model.getTitle())
                .deletedAt(model.getDeletedAt())
                .isOptional(model.getIsOptional())
                .build();
    }

}
