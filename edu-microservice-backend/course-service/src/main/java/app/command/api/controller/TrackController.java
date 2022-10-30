package app.command.api.controller;

import app.command.api.model.StepQuizRequestModel;
import app.command.api.model.TrackRequestModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface TrackController {

    String save(@RequestBody TrackRequestModel model);

    String update(@RequestBody TrackRequestModel model);

    String delete(@PathVariable String id);

}
