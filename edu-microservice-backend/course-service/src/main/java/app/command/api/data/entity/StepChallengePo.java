package app.command.api.data.entity;

import java.io.Serializable;
import java.util.Date;

public class StepChallengePo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private Integer duration;
	private Date updatedAt;
	private Date createdAt;
	private String description;
	private String title;
	private String content;

	public StepChallengePo() { }

	public StepChallengePo(Integer duration, Date updatedAt, Date createdAt, String description, String id, String title, String content) {
		this.duration = duration;
		this.updatedAt = updatedAt;
		this.createdAt = createdAt;
		this.description = description;
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

	public static StepChallengePoBuilder builder() {
		return new StepChallengePoBuilder();
	}
	public static class StepChallengePoBuilder {

		private Integer duration;
		private Date updatedAt;
		private Date createdAt;
		private String description;
		private String id;
		private String title;
		private String content;

		public StepChallengePoBuilder duration(Integer duration) {
			this.duration = duration;
			return this;
		}
		public StepChallengePoBuilder updatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
			return this;
		}
		public StepChallengePoBuilder createdAt(Date createdAt) {
			this.createdAt = createdAt;
			return this;
		}
		public StepChallengePoBuilder description(String description) {
			this.description = description;
			return this;
		}
		public StepChallengePoBuilder id(String id) {
			this.id = id;
			return this;
		}
		public StepChallengePoBuilder title(String title) {
			this.title = title;
			return this;
		}
		public StepChallengePoBuilder content(String content) {
			this.content = content;
			return this;
		}

		public StepChallengePo build() {
			return new StepChallengePo(this.duration, this.updatedAt, this.createdAt, this.description, this.id, this.title, this.content);
		}

	}
}