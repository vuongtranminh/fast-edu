package app.command.api.events;

import java.io.Serializable;

public class StepChallengeDeletedEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	public StepChallengeDeletedEvent() { }

	public StepChallengeDeletedEvent(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

}