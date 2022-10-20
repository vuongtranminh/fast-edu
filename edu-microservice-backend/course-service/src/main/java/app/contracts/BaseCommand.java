package app.contracts;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

public class BaseCommand implements Identifiable {

    @TargetAggregateIdentifier
    private String id;

    public BaseCommand() {
        setId(UUID.randomUUID().toString());
    }

    public BaseCommand(String id) {
        this.id = id == null ? null : id.trim();
    }

    @Override
    public String id() {
        return this.id;
    }

    protected void setId(String id) {
        this.id = id == null ? null : id.trim();
    }
}
