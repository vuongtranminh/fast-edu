package app.command.api.commands;

import java.io.Serializable;

import app.contracts.BaseCommand;
import app.contracts.BaseCreateCommand;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import java.util.Date;

public class CreateStepLessonCommand extends BaseCreateCommand implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer duration;
	private Date updatedAt;
	private Date createdAt;
	private String description;
	private String title;
	private String content;

	public CreateStepLessonCommand() {
		super();
	}

	public CreateStepLessonCommand(Integer duration, Date updatedAt, Date createdAt, String description, String title, String content) {
		super();
		this.duration = duration;
		this.updatedAt = updatedAt;
		this.createdAt = createdAt;
		this.description = description;
		this.title = title;
		this.content = content;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
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

	public static CreateStepLessonCommandBuilder builder() {
		return new CreateStepLessonCommandBuilder();
	}
	public static class CreateStepLessonCommandBuilder {

		private Integer duration;
		private Date updatedAt;
		private Date createdAt;
		private String description;
		private String title;
		private String content;

		public CreateStepLessonCommandBuilder duration(Integer duration) {
			this.duration = duration;
			return this;
		}
		public CreateStepLessonCommandBuilder updatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
			return this;
		}
		public CreateStepLessonCommandBuilder createdAt(Date createdAt) {
			this.createdAt = createdAt;
			return this;
		}
		public CreateStepLessonCommandBuilder description(String description) {
			this.description = description;
			return this;
		}
		public CreateStepLessonCommandBuilder title(String title) {
			this.title = title;
			return this;
		}
		public CreateStepLessonCommandBuilder content(String content) {
			this.content = content;
			return this;
		}

		public CreateStepLessonCommand build() {
			return new CreateStepLessonCommand(this.duration, this.updatedAt, this.createdAt, this.description, this.title, this.content);
		}

	}
}