package app.command.api.controller;

import app.command.api.model.StepChallengeRequestModel;
import app.command.api.model.StepQuizRequestModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface StepQuizController {

    String save(@RequestBody StepQuizRequestModel model);

    String update(@RequestBody StepQuizRequestModel model);

    String delete(@PathVariable String id);

}
