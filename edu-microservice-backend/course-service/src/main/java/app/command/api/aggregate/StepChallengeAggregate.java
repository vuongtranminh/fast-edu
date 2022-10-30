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
public class StepChallengeAggregate {

    @AggregateIdentifier
    private String id;
    private Integer duration;
    private Date updatedAt;
    private Date createdAt;
    private String description;
    private String title;
    private String content;

    public StepChallengeAggregate() {

    }

    @CommandHandler
    public StepChallengeAggregate(CreateStepChallengeCommand command) {
        StepChallengeCreatedEvent event = new StepChallengeCreatedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(UpdateStepChallengeCommand command) {
        StepChallengeUpdatedEvent event = new StepChallengeUpdatedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(DeleteStepChallengeCommand command) {
        StepChallengeDeletedEvent event = new StepChallengeDeletedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(StepChallengeCreatedEvent event) {
        this.id = event.getId();
        this.duration = event.getDuration();
        this.updatedAt = event.getUpdatedAt();
        this.createdAt = event.getCreatedAt();
        this.description = event.getDescription();
        this.title = event.getTitle();
        this.content = event.getContent();
    }

    @EventSourcingHandler
    public void on(StepChallengeUpdatedEvent event) {
        this.id = event.getId();
        this.duration = event.getDuration();
        this.updatedAt = event.getUpdatedAt();
        this.createdAt = event.getCreatedAt();
        this.description = event.getDescription();
        this.title = event.getTitle();
        this.content = event.getContent();
    }

    @EventSourcingHandler
    public void on(StepChallengeDeletedEvent event) {
        this.id = event.getId();
    }

}
