package app.helper;

import app.command.api.commands.CreateCourseCommand;
import app.command.api.commands.CreateQuizAnswerCommand;
import app.command.api.commands.UpdateCourseCommand;
import app.command.api.commands.UpdateQuizAnswerCommand;
import app.command.api.model.CourseRequestModel;
import app.command.api.model.QuizAnswerRequestModel;

public interface QuizAnswerMappingHelper {

    static CreateQuizAnswerCommand mapToCreateCommand(final QuizAnswerRequestModel model) {
        return CreateQuizAnswerCommand.builder()
                .quizId(model.getQuizId())
                .answer(model.getAnswer())
                .explanation(model.getExplanation())
                .isCorrect(model.getIsCorrect())
                .build();
    }

    static UpdateQuizAnswerCommand mapToUpdateCommand(final QuizAnswerRequestModel model) {
        return UpdateQuizAnswerCommand.builder()
                .id(model.getId())
                .quizId(model.getQuizId())
                .answer(model.getAnswer())
                .explanation(model.getExplanation())
                .isCorrect(model.getIsCorrect())
                .build();
    }

}
