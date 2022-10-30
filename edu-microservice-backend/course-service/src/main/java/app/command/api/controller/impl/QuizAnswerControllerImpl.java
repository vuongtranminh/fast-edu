package app.command.api.controller.impl;

import app.command.api.commands.CreateQuizAnswerCommand;
import app.command.api.commands.DeleteCourseCommand;
import app.command.api.commands.DeleteQuizAnswerCommand;
import app.command.api.commands.UpdateQuizAnswerCommand;
import app.command.api.controller.QuizAnswerController;
import app.command.api.model.QuizAnswerRequestModel;
import app.helper.QuizAnswerMappingHelper;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/quizanswers")
public class QuizAnswerControllerImpl implements QuizAnswerController {

    private CommandGateway commandGateway;

    public QuizAnswerControllerImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    @PostMapping
    public String save(QuizAnswerRequestModel model) {
        CreateQuizAnswerCommand command = QuizAnswerMappingHelper.mapToCreateCommand(model);
        commandGateway.sendAndWait(command);
        return "add quiz answer";
    }

    @Override
    @PutMapping
    public String update(QuizAnswerRequestModel model) {
        UpdateQuizAnswerCommand command = QuizAnswerMappingHelper.mapToUpdateCommand(model);
        commandGateway.sendAndWait(command);
        return "update quiz answer";
    }

    @Override
    @DeleteMapping("/{id}")
    public String delete(String id) {
        DeleteQuizAnswerCommand command = new DeleteQuizAnswerCommand(id);
        commandGateway.sendAndWait(command);
        return "delete quiz answer";
    }
}
