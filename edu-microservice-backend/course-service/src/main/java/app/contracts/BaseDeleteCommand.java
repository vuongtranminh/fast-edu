package app.contracts;

public class BaseDeleteCommand extends BaseCommand {

    public BaseDeleteCommand(String id) {
        this(id, true);
    }

    public BaseDeleteCommand(String id, boolean useDataHeader) {
        super(id);
    }
}
