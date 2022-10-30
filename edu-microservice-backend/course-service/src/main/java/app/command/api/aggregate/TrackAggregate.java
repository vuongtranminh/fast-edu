package app.command.api.aggregate;

import app.command.api.commands.*;
import app.command.api.events.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class TrackAggregate {

    @AggregateIdentifier
    private String id;
    private Integer duration;
    private String courseId;
    private Date updatedAt;
    private Boolean isFree;
    private Date createdAt;
    private Integer position;
    private String title;
    private Date deletedAt;
    private Boolean isOptional;

    public TrackAggregate() {}

    @CommandHandler
    public TrackAggregate(CreateTrackCommand command) {
        TrackCreatedEvent event = new TrackCreatedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(UpdateTrackCommand command) {
        TrackUpdatedEvent event = new TrackUpdatedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(DeleteTrackCommand command) {
        TrackDeletedEvent event = new TrackDeletedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(TrackCreatedEvent event) {
        this.id = event.getId();
        this.duration = event.getDuration();
        this.courseId = event.getCourseId();
        this.updatedAt = event.getUpdatedAt();
        this.isFree = event.getIsFree();
        this.createdAt = event.getCreatedAt();
        this.position = event.getPosition();
        this.title = event.getTitle();
        this.deletedAt = event.getDeletedAt();
        this.isOptional = event.getIsOptional();
    }

    @EventSourcingHandler
    public void on(UpdateTrackCommand event) {
        this.id = event.getId();
        this.duration = event.getDuration();
        this.courseId = event.getCourseId();
        this.updatedAt = event.getUpdatedAt();
        this.isFree = event.getIsFree();
        this.createdAt = event.getCreatedAt();
        this.position = event.getPosition();
        this.title = event.getTitle();
        this.deletedAt = event.getDeletedAt();
        this.isOptional = event.getIsOptional();
    }

    @EventSourcingHandler
    public void on(DeleteTrackCommand event) {
        this.id = event.getId();
    }
}
