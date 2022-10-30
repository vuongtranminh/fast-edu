package app.command.api.controller;

import app.command.api.model.CourseRequestModel;
import app.command.api.model.QuizAnswerRequestModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface QuizAnswerController {

    String save(@RequestBody QuizAnswerRequestModel model);

    String update(@RequestBody QuizAnswerRequestModel model);

    String delete(@PathVariable String id);

}
