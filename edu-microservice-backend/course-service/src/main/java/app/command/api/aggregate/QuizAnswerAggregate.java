package app.command.api.aggregate;

import app.command.api.commands.*;
import app.command.api.events.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class QuizAnswerAggregate {

    @AggregateIdentifier
    private String id;
    private String quizId;
    private String answer;
    private String explanation;
    private Boolean isCorrect;

    public QuizAnswerAggregate() {
    }

    @CommandHandler
    public QuizAnswerAggregate(CreateQuizAnswerCommand command) {
        QuizAnswerCreatedEvent event = new QuizAnswerCreatedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(UpdateQuizAnswerCommand command) {
        QuizAnswerUpdatedEvent event = new QuizAnswerUpdatedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(DeleteQuizAnswerCommand command) {
        QuizAnswerDeletedEvent event = new QuizAnswerDeletedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(QuizAnswerCreatedEvent event) {
        this.id = event.getId();
        this.quizId = event.getQuizId();
        this.answer = event.getAnswer();
        this.explanation = event.getExplanation();
        this.isCorrect = event.getIsCorrect();
    }

    @EventSourcingHandler
    public void on(QuizAnswerUpdatedEvent event) {
        this.id = event.getId();
        this.quizId = event.getQuizId();
        this.answer = event.getAnswer();
        this.explanation = event.getExplanation();
        this.isCorrect = event.getIsCorrect();
    }

    @EventSourcingHandler
    public void on(QuizAnswerDeletedEvent event) {
        this.id = event.getId();
    }
}
