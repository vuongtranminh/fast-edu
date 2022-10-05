package app.helper;

import app.command.api.data.AccountPo;
import app.command.api.events.AccountUpdatedEvent;

public interface AccountMappingHelper {

    public static AccountPo map(final AccountUpdatedEvent accountUpdatedEvent) {
        return AccountPo.builder()
                .username(accountUpdatedEvent.getUsername())
                .password(accountUpdatedEvent.getPassword())
                .build();
    }
}
