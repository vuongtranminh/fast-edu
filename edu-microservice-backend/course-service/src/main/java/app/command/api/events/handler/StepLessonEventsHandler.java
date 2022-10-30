package app.command.api.events.handler;

import app.command.api.data.dao.StepChallengeMapper;
import app.command.api.data.dao.StepLessonMapper;
import app.command.api.data.entity.StepChallengePo;
import app.command.api.data.entity.StepLessonPo;
import app.command.api.events.*;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class StepLessonEventsHandler {

    private StepLessonMapper mapper;

    public StepLessonEventsHandler(StepLessonMapper mapper) {
        this.mapper = mapper;
    }

    @EventHandler
    public void on(StepLessonCreatedEvent event) {
        StepLessonPo po = new StepLessonPo();
        BeanUtils.copyProperties(event, po);
        mapper.save(po);
    }

    @EventHandler
    public void on(StepLessonUpdatedEvent event) {
        StepLessonPo po = mapper.getById(event.getId());
        BeanUtils.copyProperties(event, po);
        mapper.updateById(po);
    }

    @EventHandler
    public void on(StepLessonDeletedEvent event) {
        mapper.deleteById(event.getId());
    }

}
