package app.command.api.commands;

import java.io.Serializable;

import app.contracts.BaseDeleteCommand;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class DeleteTrackStepCommand extends BaseDeleteCommand implements Serializable {

	private static final long serialVersionUID = 1L;

	public DeleteTrackStepCommand(String id) {
		super(id);
	}
}