package app.command.api.events.handler;

import app.command.api.data.dao.CourseMapper;
import app.command.api.data.entity.CoursePo;
import app.command.api.events.CourseCreatedEvent;
import app.command.api.events.CourseDeletedEvent;
import app.command.api.events.CourseUpdatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CourseEventsHandler {

    private CourseMapper mapper;

    public CourseEventsHandler(CourseMapper mapper) {
        this.mapper = mapper;
    }

    @EventHandler
    public void on(CourseCreatedEvent event) {
        CoursePo po = new CoursePo();
        BeanUtils.copyProperties(event, po);
        mapper.save(po);
    }

    @EventHandler
    public void on(CourseUpdatedEvent event) {
        CoursePo po = mapper.getById(event.getId());
        BeanUtils.copyProperties(event, po);
        mapper.updateById(po);
    }

    @EventHandler
    public void on(CourseDeletedEvent event) {
        mapper.deleteById(event.getId());
    }

}
