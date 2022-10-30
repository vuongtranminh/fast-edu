package app.command.api.events.handler;

import app.command.api.data.dao.TrackMapper;
import app.command.api.data.dao.TrackStepMapper;
import app.command.api.data.entity.TrackPo;
import app.command.api.data.entity.TrackStepPo;
import app.command.api.events.*;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TrackStepEventsHandler {

    private TrackStepMapper mapper;

    public TrackStepEventsHandler(TrackStepMapper mapper) {
        this.mapper = mapper;
    }

    @EventHandler
    public void on(TrackStepCreatedEvent event) {
        TrackStepPo po = new TrackStepPo();
        BeanUtils.copyProperties(event, po);
        mapper.save(po);
    }

    @EventHandler
    public void on(TrackStepUpdatedEvent event) {
        TrackStepPo po = mapper.getById(event.getId());
        BeanUtils.copyProperties(event, po);
        mapper.updateById(po);
    }

    @EventHandler
    public void on(TrackStepDeletedEvent event) {
        mapper.deleteById(event.getId());
    }

}
