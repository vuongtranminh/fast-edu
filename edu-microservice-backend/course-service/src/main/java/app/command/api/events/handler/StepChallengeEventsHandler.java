package app.command.api.events.handler;

import app.command.api.data.dao.QuizAnswerMapper;
import app.command.api.data.dao.StepChallengeMapper;
import app.command.api.data.entity.QuizAnswerPo;
import app.command.api.data.entity.StepChallengePo;
import app.command.api.events.*;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class StepChallengeEventsHandler {

    private StepChallengeMapper mapper;

    public StepChallengeEventsHandler(StepChallengeMapper mapper) {
        this.mapper = mapper;
    }

    @EventHandler
    public void on(StepChallengeCreatedEvent event) {
        StepChallengePo po = new StepChallengePo();
        BeanUtils.copyProperties(event, po);
        mapper.save(po);
    }

    @EventHandler
    public void on(StepChallengeUpdatedEvent event) {
        StepChallengePo po = mapper.getById(event.getId());
        BeanUtils.copyProperties(event, po);
        mapper.updateById(po);
    }

    @EventHandler
    public void on(StepChallengeDeletedEvent event) {
        mapper.deleteById(event.getId());
    }

}
