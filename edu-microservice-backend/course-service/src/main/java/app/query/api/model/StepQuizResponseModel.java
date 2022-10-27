package app.query.api.model;

import java.io.Serializable;
import java.util.Date;

public class StepQuizResponseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private Integer duration;
	private Date updatedAt;
	private Date createdAt;
	private String title;
	private String content;

	public StepQuizResponseModel() { }

	public StepQuizResponseModel(Integer duration, Date updatedAt, Date createdAt, String id, String title, String content) {
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

	public static StepQuizResponseModelBuilder builder() {
		return new StepQuizResponseModelBuilder();
	}
	public static class StepQuizResponseModelBuilder {

		private Integer duration;
		private Date updatedAt;
		private Date createdAt;
		private String id;
		private String title;
		private String content;

		public StepQuizResponseModelBuilder duration(Integer duration) {
			this.duration = duration;
			return this;
		}
		public StepQuizResponseModelBuilder updatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
			return this;
		}
		public StepQuizResponseModelBuilder createdAt(Date createdAt) {
			this.createdAt = createdAt;
			return this;
		}
		public StepQuizResponseModelBuilder id(String id) {
			this.id = id;
			return this;
		}
		public StepQuizResponseModelBuilder title(String title) {
			this.title = title;
			return this;
		}
		public StepQuizResponseModelBuilder content(String content) {
			this.content = content;
			return this;
		}

		public StepQuizResponseModel build() {
			return new StepQuizResponseModel(this.duration, this.updatedAt, this.createdAt, this.id, this.title, this.content);
		}

	}
}