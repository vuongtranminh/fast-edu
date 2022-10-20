package app.command.api.commands;

import java.io.Serializable;

import app.contracts.BaseCommand;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class DeleteAccountCommand extends BaseCommand implements Serializable {

	private static final long serialVersionUID = 1L;

	public DeleteAccountCommand(String id) {
		super(id);
	}

}