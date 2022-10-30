package app.command.api.controller;

import app.command.api.model.StepLessonRequestModel;
import app.command.api.model.StepQuizRequestModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface StepLessonController {

    String save(@RequestBody StepLessonRequestModel model);

    String update(@RequestBody StepLessonRequestModel model);

    String delete(@PathVariable String id);

}
