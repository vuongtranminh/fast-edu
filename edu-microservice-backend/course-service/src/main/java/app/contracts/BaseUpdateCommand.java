package app.contracts;

public class BaseUpdateCommand extends BaseCommand {

    public BaseUpdateCommand(String id) {
        this(id, true);
    }

    public BaseUpdateCommand(String id, boolean useDataHeader) {
        super(id);
    }
}
