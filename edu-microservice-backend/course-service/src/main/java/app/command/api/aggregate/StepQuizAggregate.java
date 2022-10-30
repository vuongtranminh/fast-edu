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
public class StepQuizAggregate {

    @AggregateIdentifier
    private String id;
    private Integer duration;
    private Date updatedAt;
    private Date createdAt;
    private String title;
    private String content;

    public StepQuizAggregate() {}

    @CommandHandler
    public StepQuizAggregate(CreateStepQuizCommand command) {
        StepQuizCreatedEvent event = new StepQuizCreatedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(UpdateStepQuizCommand command) {
        StepQuizUpdatedEvent event = new StepQuizUpdatedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(DeleteStepQuizCommand command) {
        StepQuizDeletedEvent event = new StepQuizDeletedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(StepQuizCreatedEvent event) {
        this.id = event.getId();
        this.duration = event.getDuration();
        this.updatedAt = event.getUpdatedAt();
        this.createdAt = event.getCreatedAt();
        this.title = event.getTitle();
        this.content = event.getContent();
    }

    @EventSourcingHandler
    public void on(StepQuizUpdatedEvent event) {
        this.id = event.getId();
        this.duration = event.getDuration();
        this.updatedAt = event.getUpdatedAt();
        this.createdAt = event.getCreatedAt();
        this.title = event.getTitle();
        this.content = event.getContent();
    }

    @EventSourcingHandler
    public void on(StepQuizDeletedEvent event) {
        this.id = event.getId();
    }
}
