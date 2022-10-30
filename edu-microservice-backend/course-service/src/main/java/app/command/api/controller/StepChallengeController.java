package app.command.api.controller;

import app.command.api.model.QuizAnswerRequestModel;
import app.command.api.model.StepChallengeRequestModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface StepChallengeController {

    String save(@RequestBody StepChallengeRequestModel model);

    String update(@RequestBody StepChallengeRequestModel model);

    String delete(@PathVariable String id);

}
