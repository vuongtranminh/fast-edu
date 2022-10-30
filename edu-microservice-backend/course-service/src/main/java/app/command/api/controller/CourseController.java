package app.command.api.controller;

import app.command.api.model.AccountRequestModel;
import app.command.api.model.CourseRequestModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface CourseController {

    String save(@RequestBody CourseRequestModel model);

    String update(@RequestBody CourseRequestModel model);

    String delete(@PathVariable String id);

}
