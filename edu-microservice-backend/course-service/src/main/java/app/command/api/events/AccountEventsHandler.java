package app.command.api.events;

import org.axonframework.eventhandling.EventHandler;

public interface AccountEventsHandler {

    public void on(AccountCreatedEvent event);

    public void on(AccountUpdatedEvent event);

    public void on(AccountDeletedEvent event);

}
