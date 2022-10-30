package app.command.api.controller;

import app.command.api.model.TrackRequestModel;
import app.command.api.model.TrackStepRequestModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface TrackStepController {

    String save(@RequestBody TrackStepRequestModel model);

    String update(@RequestBody TrackStepRequestModel model);

    String delete(@PathVariable String id);

}
