package app.helper;

import app.command.api.commands.CreateStepChallengeCommand;
import app.command.api.commands.CreateStepQuizCommand;
import app.command.api.commands.UpdateStepChallengeCommand;
import app.command.api.commands.UpdateStepQuizCommand;
import app.command.api.model.StepChallengeRequestModel;
import app.command.api.model.StepQuizRequestModel;

import java.util.Date;

public interface StepQuizMappingHelper {

    static CreateStepQuizCommand mapToCreateCommand(final StepQuizRequestModel model) {
        return CreateStepQuizCommand.builder()
                .duration(model.getDuration())
                .updatedAt(model.getUpdatedAt())
                .createdAt(model.getCreatedAt())
                .title(model.getTitle())
                .content(model.getContent())
                .build();
    }

    static UpdateStepQuizCommand mapToUpdateCommand(final StepQuizRequestModel model) {
        return UpdateStepQuizCommand.builder()
                .id(model.getId())
                .duration(model.getDuration())
                .updatedAt(model.getUpdatedAt())
                .createdAt(model.getCreatedAt())
                .title(model.getTitle())
                .content(model.getContent())
                .build();
    }

}
