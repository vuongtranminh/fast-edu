package app.command.api.controller.impl;

import app.command.api.commands.CreateCourseCommand;
import app.command.api.commands.DeleteCourseCommand;
import app.command.api.commands.UpdateCourseCommand;
import app.command.api.controller.CourseController;
import app.command.api.model.CourseRequestModel;
import app.helper.CourseMappingHelper;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseControllerImpl implements CourseController {

    private CommandGateway commandGateway;

    public CourseControllerImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    @PostMapping
    public String save(CourseRequestModel model) {
        CreateCourseCommand command = CourseMappingHelper.mapToCreateCommand(model);
        commandGateway.sendAndWait(command);
        return "add course";
    }

    @Override
    @PutMapping
    public String update(CourseRequestModel model) {
        UpdateCourseCommand command = CourseMappingHelper.mapToUpdateCommand(model);
        commandGateway.sendAndWait(command);
        return "update course";
    }

    @Override
    @DeleteMapping("/{id}")
    public String delete(String id) {
        DeleteCourseCommand command = new DeleteCourseCommand(id);
        commandGateway.sendAndWait(command);
        return "delete course";
    }
}
