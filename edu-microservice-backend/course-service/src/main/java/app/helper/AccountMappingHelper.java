package app.helper;

public interface AccountMappingHelper {

    public static AccountPo map(final AccountUpdatedEvent accountUpdatedEvent) {
        return AccountPo.builder()
                .username(accountUpdatedEvent.getUsername())
                .password(accountUpdatedEvent.getPassword())
                .build();
    }
}
