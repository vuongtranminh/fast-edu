package app.query.api.model;

import java.io.Serializable;
import java.util.Date;

public class StepChallengeResponseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private Integer duration;
	private Date updatedAt;
	private Date createdAt;
	private String description;
	private String title;
	private String content;

	public StepChallengeResponseModel() { }

	public StepChallengeResponseModel(Integer duration, Date updatedAt, Date createdAt, String description, String id, String title, String content) {
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

	public static StepChallengeResponseModelBuilder builder() {
		return new StepChallengeResponseModelBuilder();
	}
	public static class StepChallengeResponseModelBuilder {

		private Integer duration;
		private Date updatedAt;
		private Date createdAt;
		private String description;
		private String id;
		private String title;
		private String content;

		public StepChallengeResponseModelBuilder duration(Integer duration) {
			this.duration = duration;
			return this;
		}
		public StepChallengeResponseModelBuilder updatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
			return this;
		}
		public StepChallengeResponseModelBuilder createdAt(Date createdAt) {
			this.createdAt = createdAt;
			return this;
		}
		public StepChallengeResponseModelBuilder description(String description) {
			this.description = description;
			return this;
		}
		public StepChallengeResponseModelBuilder id(String id) {
			this.id = id;
			return this;
		}
		public StepChallengeResponseModelBuilder title(String title) {
			this.title = title;
			return this;
		}
		public StepChallengeResponseModelBuilder content(String content) {
			this.content = content;
			return this;
		}

		public StepChallengeResponseModel build() {
			return new StepChallengeResponseModel(this.duration, this.updatedAt, this.createdAt, this.description, this.id, this.title, this.content);
		}

	}
}