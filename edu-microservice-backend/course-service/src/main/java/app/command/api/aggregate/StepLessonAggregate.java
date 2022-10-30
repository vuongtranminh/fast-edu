package app.command.api.aggregate;

import app.command.api.commands.CreateStepLessonCommand;
import app.command.api.commands.DeleteStepLessonCommand;
import app.command.api.commands.UpdateStepLessonCommand;
import app.command.api.events.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class StepLessonAggregate {

    @AggregateIdentifier
    private String id;
    private Integer duration;
    private Date updatedAt;
    private Date createdAt;
    private String description;
    private String title;
    private String content;

    public StepLessonAggregate() {

    }

    @CommandHandler
    public StepLessonAggregate(CreateStepLessonCommand command) {
        StepLessonCreatedEvent event = new StepLessonCreatedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(UpdateStepLessonCommand command) {
        StepLessonUpdatedEvent event = new StepLessonUpdatedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(DeleteStepLessonCommand command) {
        StepLessonDeletedEvent event = new StepLessonDeletedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(StepLessonCreatedEvent event) {
        this.id = event.getId();
        this.duration = event.getDuration();
        this.updatedAt = event.getUpdatedAt();
        this.createdAt = event.getCreatedAt();
        this.description = event.getDescription();
        this.title = event.getTitle();
        this.content = event.getContent();
    }

    @EventSourcingHandler
    public void on(StepLessonUpdatedEvent event) {
        this.id = event.getId();
        this.duration = event.getDuration();
        this.updatedAt = event.getUpdatedAt();
        this.createdAt = event.getCreatedAt();
        this.description = event.getDescription();
        this.title = event.getTitle();
        this.content = event.getContent();
    }

    @EventSourcingHandler
    public void on(StepLessonDeletedEvent event) {
        this.id = event.getId();
    }

}
