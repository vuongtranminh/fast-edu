package app.command.api.commands;

import java.io.Serializable;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class DeleteCourseCommand implements Serializable {

	private static final long serialVersionUID = 1L;
	@TargetAggregateIdentifier
	private String id;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

}