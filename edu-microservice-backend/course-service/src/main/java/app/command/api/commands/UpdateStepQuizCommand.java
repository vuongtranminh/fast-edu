package app.command.api.commands;

import java.io.Serializable;

import app.contracts.BaseUpdateCommand;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import java.util.Date;

public class UpdateStepQuizCommand extends BaseUpdateCommand implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer duration;
	private Date updatedAt;
	private Date createdAt;
	private String title;
	private String content;

	public UpdateStepQuizCommand(String id) {
		super(id);
	}

	public UpdateStepQuizCommand(Integer duration, Date updatedAt, Date createdAt, String id, String title, String content) {
		super(id);
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

	public static UpdateStepQuizCommandBuilder builder() {
		return new UpdateStepQuizCommandBuilder();
	}
	public static class UpdateStepQuizCommandBuilder {

		private Integer duration;
		private Date updatedAt;
		private Date createdAt;
		private String id;
		private String title;
		private String content;

		public UpdateStepQuizCommandBuilder duration(Integer duration) {
			this.duration = duration;
			return this;
		}
		public UpdateStepQuizCommandBuilder updatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
			return this;
		}
		public UpdateStepQuizCommandBuilder createdAt(Date createdAt) {
			this.createdAt = createdAt;
			return this;
		}
		public UpdateStepQuizCommandBuilder id(String id) {
			this.id = id;
			return this;
		}
		public UpdateStepQuizCommandBuilder title(String title) {
			this.title = title;
			return this;
		}
		public UpdateStepQuizCommandBuilder content(String content) {
			this.content = content;
			return this;
		}

		public UpdateStepQuizCommand build() {
			return new UpdateStepQuizCommand(this.duration, this.updatedAt, this.createdAt, this.id, this.title, this.content);
		}

	}
}