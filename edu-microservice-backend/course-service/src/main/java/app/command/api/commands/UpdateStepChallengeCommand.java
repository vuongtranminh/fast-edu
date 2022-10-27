package app.command.api.commands;

import java.io.Serializable;

import app.contracts.BaseUpdateCommand;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import java.util.Date;

public class UpdateStepChallengeCommand extends BaseUpdateCommand implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer duration;
	private Date updatedAt;
	private Date createdAt;
	private String description;
	private String title;
	private String content;

	public UpdateStepChallengeCommand(String id) {
		super(id);
	}

	public UpdateStepChallengeCommand(Integer duration, Date updatedAt, Date createdAt, String description, String id, String title, String content) {
		super(id);
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

	public static UpdateStepChallengeCommandBuilder builder() {
		return new UpdateStepChallengeCommandBuilder();
	}
	public static class UpdateStepChallengeCommandBuilder {

		private Integer duration;
		private Date updatedAt;
		private Date createdAt;
		private String description;
		private String id;
		private String title;
		private String content;

		public UpdateStepChallengeCommandBuilder duration(Integer duration) {
			this.duration = duration;
			return this;
		}
		public UpdateStepChallengeCommandBuilder updatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
			return this;
		}
		public UpdateStepChallengeCommandBuilder createdAt(Date createdAt) {
			this.createdAt = createdAt;
			return this;
		}
		public UpdateStepChallengeCommandBuilder description(String description) {
			this.description = description;
			return this;
		}
		public UpdateStepChallengeCommandBuilder id(String id) {
			this.id = id;
			return this;
		}
		public UpdateStepChallengeCommandBuilder title(String title) {
			this.title = title;
			return this;
		}
		public UpdateStepChallengeCommandBuilder content(String content) {
			this.content = content;
			return this;
		}

		public UpdateStepChallengeCommand build() {
			return new UpdateStepChallengeCommand(this.duration, this.updatedAt, this.createdAt, this.description, this.id, this.title, this.content);
		}

	}
}