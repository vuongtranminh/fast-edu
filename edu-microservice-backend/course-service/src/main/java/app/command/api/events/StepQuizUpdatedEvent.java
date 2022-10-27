package app.command.api.events;

import java.io.Serializable;
import java.util.Date;

public class StepQuizUpdatedEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private Integer duration;
	private Date updatedAt;
	private Date createdAt;
	private String title;
	private String content;

	public StepQuizUpdatedEvent() { }

	public StepQuizUpdatedEvent(Integer duration, Date updatedAt, Date createdAt, String id, String title, String content) {
		this.duration = duration;
		this.updatedAt = updatedAt;
		this.createdAt = createdAt;
		this.id = id;
		this.title = title;
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public static StepQuizUpdatedEventBuilder builder() {
		return new StepQuizUpdatedEventBuilder();
	}
	public static class StepQuizUpdatedEventBuilder {

		private Integer duration;
		private Date updatedAt;
		private Date createdAt;
		private String id;
		private String title;
		private String content;

		public StepQuizUpdatedEventBuilder duration(Integer duration) {
			this.duration = duration;
			return this;
		}
		public StepQuizUpdatedEventBuilder updatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
			return this;
		}
		public StepQuizUpdatedEventBuilder createdAt(Date createdAt) {
			this.createdAt = createdAt;
			return this;
		}
		public StepQuizUpdatedEventBuilder id(String id) {
			this.id = id;
			return this;
		}
		public StepQuizUpdatedEventBuilder title(String title) {
			this.title = title;
			return this;
		}
		public StepQuizUpdatedEventBuilder content(String content) {
			this.content = content;
			return this;
		}

		public StepQuizUpdatedEvent build() {
			return new StepQuizUpdatedEvent(this.duration, this.updatedAt, this.createdAt, this.id, this.title, this.content);
		}

	}
}