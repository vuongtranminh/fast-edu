package app.command.api.events.handler;

import app.command.api.data.dao.CourseMapper;
import app.command.api.data.dao.QuizAnswerMapper;
import app.command.api.data.entity.CoursePo;
import app.command.api.data.entity.QuizAnswerPo;
import app.command.api.events.*;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class QuizAnswerEventsHandler {

    private QuizAnswerMapper mapper;

    public QuizAnswerEventsHandler(QuizAnswerMapper mapper) {
        this.mapper = mapper;
    }

    @EventHandler
    public void on(QuizAnswerCreatedEvent event) {
        QuizAnswerPo po = new QuizAnswerPo();
        BeanUtils.copyProperties(event, po);
        mapper.save(po);
    }

    @EventHandler
    public void on(QuizAnswerUpdatedEvent event) {
        QuizAnswerPo po = mapper.getById(event.getId());
        BeanUtils.copyProperties(event, po);
        mapper.updateById(po);
    }

    @EventHandler
    public void on(QuizAnswerDeletedEvent event) {
        mapper.deleteById(event.getId());
    }

}
