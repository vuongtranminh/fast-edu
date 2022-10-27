package app.contracts;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

public class BaseCommand implements Identifiable<String> {

    @TargetAggregateIdentifier
    private String id;

    public BaseCommand() {
        this(UUID.randomUUID().toString());
    }

    public BaseCommand(String id) {
        setId(id);
    }

    @Override
    public String getId() {
        return this.id;
    }

    protected void setId(String id) {
        this.id = id == null ? null : id.trim();
    }
}
