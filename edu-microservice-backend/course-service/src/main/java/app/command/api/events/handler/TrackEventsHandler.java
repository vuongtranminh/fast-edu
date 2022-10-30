package app.command.api.events.handler;

import app.command.api.data.dao.StepQuizMapper;
import app.command.api.data.dao.TrackMapper;
import app.command.api.data.entity.StepQuizPo;
import app.command.api.data.entity.TrackPo;
import app.command.api.events.*;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TrackEventsHandler {

    private TrackMapper mapper;

    public TrackEventsHandler(TrackMapper mapper) {
        this.mapper = mapper;
    }

    @EventHandler
    public void on(TrackCreatedEvent event) {
        TrackPo po = new TrackPo();
        BeanUtils.copyProperties(event, po);
        mapper.save(po);
    }

    @EventHandler
    public void on(TrackUpdatedEvent event) {
        TrackPo po = mapper.getById(event.getId());
        BeanUtils.copyProperties(event, po);
        mapper.updateById(po);
    }

    @EventHandler
    public void on(TrackDeletedEvent event) {
        mapper.deleteById(event.getId());
    }

}
