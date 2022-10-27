package app.command.api.events;

import java.io.Serializable;

public class CourseDeletedEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	public CourseDeletedEvent() { }

	public CourseDeletedEvent(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

}