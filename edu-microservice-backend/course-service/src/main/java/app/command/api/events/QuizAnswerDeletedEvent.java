package app.command.api.events;

import java.io.Serializable;

public class QuizAnswerDeletedEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	public QuizAnswerDeletedEvent() { }

	public QuizAnswerDeletedEvent(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

}