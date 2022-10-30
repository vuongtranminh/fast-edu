package app.helper;

import app.command.api.commands.CreateQuizAnswerCommand;
import app.command.api.commands.CreateStepChallengeCommand;
import app.command.api.commands.UpdateQuizAnswerCommand;
import app.command.api.commands.UpdateStepChallengeCommand;
import app.command.api.model.QuizAnswerRequestModel;
import app.command.api.model.StepChallengeRequestModel;

import java.util.Date;

public interface StepChallengeMappingHelper {

    static CreateStepChallengeCommand mapToCreateCommand(final StepChallengeRequestModel model) {
        return CreateStepChallengeCommand.builder()
                .duration(model.getDuration())
                .updatedAt(model.getUpdatedAt())
                .createdAt(model.getCreatedAt())
                .description(model.getDescription())
                .title(model.getTitle())
                .content(model.getContent())
                .build();
    }

    static UpdateStepChallengeCommand mapToUpdateCommand(final StepChallengeRequestModel model) {
        return UpdateStepChallengeCommand.builder()
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
