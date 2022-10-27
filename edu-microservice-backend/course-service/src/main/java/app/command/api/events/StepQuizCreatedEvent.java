package app.command.api.events;

import java.io.Serializable;
import java.util.Date;

public class StepQuizCreatedEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private Integer duration;
	private Date updatedAt;
	private Date createdAt;
	private String title;
	private String content;

	public StepQuizCreatedEvent() { }

	public StepQuizCreatedEvent(Integer duration, Date updatedAt, Date createdAt, String id, String title, String content) {
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

	public static StepQuizCreatedEventBuilder builder() {
		return new StepQuizCreatedEventBuilder();
	}
	public static class StepQuizCreatedEventBuilder {

		private Integer duration;
		private Date updatedAt;
		private Date createdAt;
		private String id;
		private String title;
		private String content;

		public StepQuizCreatedEventBuilder duration(Integer duration) {
			this.duration = duration;
			return this;
		}
		public StepQuizCreatedEventBuilder updatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
			return this;
		}
		public StepQuizCreatedEventBuilder createdAt(Date createdAt) {
			this.createdAt = createdAt;
			return this;
		}
		public StepQuizCreatedEventBuilder id(String id) {
			this.id = id;
			return this;
		}
		public StepQuizCreatedEventBuilder title(String title) {
			this.title = title;
			return this;
		}
		public StepQuizCreatedEventBuilder content(String content) {
			this.content = content;
			return this;
		}

		public StepQuizCreatedEvent build() {
			return new StepQuizCreatedEvent(this.duration, this.updatedAt, this.createdAt, this.id, this.title, this.content);
		}

	}
}