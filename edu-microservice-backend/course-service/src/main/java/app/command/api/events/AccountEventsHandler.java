package app.command.api.events;

import org.axonframework.eventhandling.EventHandler;

public interface AccountEventsHandler {

    @EventHandler
    public void on(AccountCreatedEvent event);

    @EventHandler
    public void on(AccountUpdatedEvent event);

    @EventHandler
    public void on(AccountDeletedEvent event);

}
