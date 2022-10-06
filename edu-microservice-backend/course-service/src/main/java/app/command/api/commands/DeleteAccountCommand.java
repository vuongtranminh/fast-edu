package app.command.api.commands;

import java.io.Serializable;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class DeleteAccountCommand implements Serializable {

	private static final long serialVersionUID = 1L;

	@TargetAggregateIdentifier
	private Integer id;

	public DeleteAccountCommand() { }

	public DeleteAccountCommand(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}