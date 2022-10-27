package app.command.api.commands;

import java.io.Serializable;

import app.contracts.BaseDeleteCommand;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class DeleteCourseCommand extends BaseDeleteCommand implements Serializable {

	private static final long serialVersionUID = 1L;

	public DeleteCourseCommand(String id) {
		super(id);
	}
}