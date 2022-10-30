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
public class TrackStepAggregate {

    @AggregateIdentifier
    private String id;
    private Date updatedAt;
    private Boolean isBookmarked;
    private Boolean isPublished;
    private String stepType;
    private String trackId;
    private String trackStepLevelId;
    private Integer position;
    private String stepId;
    private Date publishedAt;
    private Date deletedAt;

    public TrackStepAggregate() {}

    @CommandHandler
    public TrackStepAggregate(CreateTrackStepCommand command) {
        TrackStepCreatedEvent event = new TrackStepCreatedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }
    @CommandHandler
    public void handle(UpdateTrackStepCommand command) {
        TrackStepUpdatedEvent event = new TrackStepUpdatedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(DeleteTrackStepCommand command) {
        TrackStepDeletedEvent event = new TrackStepDeletedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(TrackStepCreatedEvent event) {
        this.id = event.getId();
        this.updatedAt = event.getUpdatedAt();
        this.isBookmarked = event.getIsBookmarked();
        this.isPublished = event.getIsPublished();
        this.stepType = event.getStepType();
        this.trackId = event.getTrackId();
        this.trackStepLevelId = event.getTrackStepLevelId();
        this.position = event.getPosition();
        this.stepId = event.getStepId();
        this.publishedAt = event.getPublishedAt();
        this.deletedAt = event.getDeletedAt();
    }

    @EventSourcingHandler
    public void on(UpdateTrackStepCommand event) {
        this.id = event.getId();
        this.updatedAt = event.getUpdatedAt();
        this.isBookmarked = event.getIsBookmarked();
        this.isPublished = event.getIsPublished();
        this.stepType = event.getStepType();
        this.trackId = event.getTrackId();
        this.trackStepLevelId = event.getTrackStepLevelId();
        this.position = event.getPosition();
        this.stepId = event.getStepId();
        this.publishedAt = event.getPublishedAt();
        this.deletedAt = event.getDeletedAt();
    }

    @EventSourcingHandler
    public void on(DeleteTrackStepCommand event) {
        this.id = event.getId();
    }

}
