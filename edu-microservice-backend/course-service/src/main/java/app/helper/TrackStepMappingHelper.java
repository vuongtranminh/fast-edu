package app.helper;

import app.command.api.commands.CreateTrackCommand;
import app.command.api.commands.CreateTrackStepCommand;
import app.command.api.commands.UpdateTrackCommand;
import app.command.api.commands.UpdateTrackStepCommand;
import app.command.api.model.TrackRequestModel;
import app.command.api.model.TrackStepRequestModel;

import java.util.Date;

public interface TrackStepMappingHelper {

    static CreateTrackStepCommand mapToCreateCommand(final TrackStepRequestModel model) {
        return CreateTrackStepCommand.builder()
                .updatedAt(model.getUpdatedAt())
                .isBookmarked(model.getIsBookmarked())
                .isPublished(model.getIsPublished())
                .stepType(model.getStepType())
                .trackId(model.getTrackId())
                .trackStepLevelId(model.getTrackStepLevelId())
                .position(model.getPosition())
                .stepId(model.getStepId())
                .publishedAt(model.getPublishedAt())
                .deletedAt(model.getDeletedAt())
                .build();
    }

    static UpdateTrackStepCommand mapToUpdateCommand(final TrackStepRequestModel model) {
        return UpdateTrackStepCommand.builder()
                .id(model.getId())
                .updatedAt(model.getUpdatedAt())
                .isBookmarked(model.getIsBookmarked())
                .isPublished(model.getIsPublished())
                .stepType(model.getStepType())
                .trackId(model.getTrackId())
                .trackStepLevelId(model.getTrackStepLevelId())
                .position(model.getPosition())
                .stepId(model.getStepId())
                .publishedAt(model.getPublishedAt())
                .deletedAt(model.getDeletedAt())
                .build();
    }

}
