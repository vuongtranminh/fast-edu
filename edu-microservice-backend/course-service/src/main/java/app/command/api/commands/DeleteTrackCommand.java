package app.command.api.commands;

import java.io.Serializable;

import app.contracts.BaseDeleteCommand;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class DeleteTrackCommand extends BaseDeleteCommand implements Serializable {

	private static final long serialVersionUID = 1L;

	public DeleteTrackCommand(String id) {
		super(id);
	}
}