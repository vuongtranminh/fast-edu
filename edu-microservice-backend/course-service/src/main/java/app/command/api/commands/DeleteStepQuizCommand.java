package app.command.api.commands;

import java.io.Serializable;

import app.contracts.BaseDeleteCommand;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class DeleteStepQuizCommand extends BaseDeleteCommand implements Serializable {

	private static final long serialVersionUID = 1L;

	public DeleteStepQuizCommand(String id) {
		super(id);
	}
}