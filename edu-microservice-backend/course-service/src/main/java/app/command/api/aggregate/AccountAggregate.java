package app.command.api.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class AccountAggregate {

    @AggregateIdentifier
    private String id;
    private String password;
    private String username;

    public AccountAggregate() {
    }

    @CommandHandler
    public AccountAggregate(CreateAccountCommand command) {
        //You can perform all the validations
        AccountCreatedEvent event
                = new AccountCreatedEvent();
        BeanUtils.copyProperties(command,
                event);
        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(UpdateAccountCommand command) {
        AccountUpdatedEvent event
                = new AccountUpdatedEvent();
        BeanUtils.copyProperties(command,
                event);

        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(DeleteAccountCommand command) {
        AccountDeletedEvent event
                = new AccountDeletedEvent();
        BeanUtils.copyProperties(command,
                event);

        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(AccountCreatedEvent event) {
        this.id = event.getId();
        this.password = event.getPassword();
        this.username = event.getUsername();
    }

    @EventSourcingHandler
    public void on(AccountUpdatedEvent event) {
        this.id = event.getId();
        this.password = event.getPassword();
        this.username = event.getUsername();
    }

    @EventSourcingHandler
    public void on(AccountDeletedEvent event) {
        this.id = event.getId();
    }

}
