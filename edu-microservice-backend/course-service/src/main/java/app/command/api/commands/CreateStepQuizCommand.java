package app.command.api.commands;

import java.io.Serializable;

import app.contracts.BaseCommand;
import app.contracts.BaseCreateCommand;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import java.util.Date;

public class CreateStepQuizCommand extends BaseCreateCommand implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer duration;
	private Date updatedAt;
	private Date createdAt;
	private String title;
	private String content;

	public CreateStepQuizCommand() {
		super();
	}

	public CreateStepQuizCommand(Integer duration, Date updatedAt, Date createdAt, String title, String content) {
		super();
		this.duration = duration;
		this.updatedAt = updatedAt;
		this.createdAt = createdAt;
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

	public static CreateStepQuizCommandBuilder builder() {
		return new CreateStepQuizCommandBuilder();
	}
	public static class CreateStepQuizCommandBuilder {

		private Integer duration;
		private Date updatedAt;
		private Date createdAt;
		private String title;
		private String content;

		public CreateStepQuizCommandBuilder duration(Integer duration) {
			this.duration = duration;
			return this;
		}
		public CreateStepQuizCommandBuilder updatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
			return this;
		}
		public CreateStepQuizCommandBuilder createdAt(Date createdAt) {
			this.createdAt = createdAt;
			return this;
		}
		public CreateStepQuizCommandBuilder title(String title) {
			this.title = title;
			return this;
		}
		public CreateStepQuizCommandBuilder content(String content) {
			this.content = content;
			return this;
		}

		public CreateStepQuizCommand build() {
			return new CreateStepQuizCommand(this.duration, this.updatedAt, this.createdAt, this.title, this.content);
		}

	}
}