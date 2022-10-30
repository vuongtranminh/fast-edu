package app.command.api.events.handler;

import app.command.api.data.dao.StepLessonMapper;
import app.command.api.data.dao.StepQuizMapper;
import app.command.api.data.entity.StepLessonPo;
import app.command.api.data.entity.StepQuizPo;
import app.command.api.events.*;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class StepQuizEventsHandler {

    private StepQuizMapper mapper;

    public StepQuizEventsHandler(StepQuizMapper mapper) {
        this.mapper = mapper;
    }

    @EventHandler
    public void on(StepQuizCreatedEvent event) {
        StepQuizPo po = new StepQuizPo();
        BeanUtils.copyProperties(event, po);
        mapper.save(po);
    }

    @EventHandler
    public void on(StepQuizUpdatedEvent event) {
        StepQuizPo po = mapper.getById(event.getId());
        BeanUtils.copyProperties(event, po);
        mapper.updateById(po);
    }

    @EventHandler
    public void on(StepQuizDeletedEvent event) {
        mapper.deleteById(event.getId());
    }

}
