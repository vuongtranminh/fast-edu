package app.helper;

import app.command.api.commands.CreateStepLessonCommand;
import app.command.api.commands.CreateStepQuizCommand;
import app.command.api.commands.UpdateStepLessonCommand;
import app.command.api.commands.UpdateStepQuizCommand;
import app.command.api.model.StepLessonRequestModel;
import app.command.api.model.StepQuizRequestModel;

import java.util.Date;

public interface StepLessonMappingHelper {

    static CreateStepLessonCommand mapToCreateCommand(final StepLessonRequestModel model) {
        return CreateStepLessonCommand.builder()
                .duration(model.getDuration())
                .updatedAt(model.getUpdatedAt())
                .createdAt(model.getCreatedAt())
                .description(model.getDescription())
                .title(model.getTitle())
                .content(model.getContent())
                .build();
    }

    static UpdateStepLessonCommand mapToUpdateCommand(final StepLessonRequestModel model) {
        return UpdateStepLessonCommand.builder()
                .id(model.getId())
                .duration(model.getDuration())
                .updatedAt(model.getUpdatedAt())
                .createdAt(model.getCreatedAt())
                .description(model.getDescription())
                .title(model.getTitle())
                .content(model.getContent())
                .build();
    }

}
