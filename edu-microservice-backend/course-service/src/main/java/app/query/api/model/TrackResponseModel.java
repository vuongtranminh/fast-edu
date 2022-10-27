package app.query.api.model;

import java.io.Serializable;
import java.util.Date;

public class TrackResponseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private Integer duration;
	private String courseId;
	private Date updatedAt;
	private Boolean isFree;
	private Date createdAt;
	private Integer position;
	private String title;
	private Date deletedAt;
	private Boolean isOptional;

	public TrackResponseModel() { }

	public TrackResponseModel(Integer duration, String courseId, Date updatedAt, Boolean isFree, Date createdAt, String id, Integer position, String title, Date deletedAt, Boolean isOptional) {
		this.duration = duration;
		this.courseId = courseId;
		this.updatedAt = updatedAt;
		this.isFree = isFree;
		this.createdAt = createdAt;
		this.id = id;
		this.position = position;
		this.title = title;
		this.deletedAt = deletedAt;
		this.isOptional = isOptional;
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
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId == null ? null : courseId.trim();
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Boolean getIsFree() {
		return isFree;
	}
	public void setIsFree(Boolean isFree) {
		this.isFree = isFree;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}
	public Date getDeletedAt() {
		return deletedAt;
	}
	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}
	public Boolean getIsOptional() {
		return isOptional;
	}
	public void setIsOptional(Boolean isOptional) {
		this.isOptional = isOptional;
	}

	public static TrackResponseModelBuilder builder() {
		return new TrackResponseModelBuilder();
	}
	public static class TrackResponseModelBuilder {

		private Integer duration;
		private String courseId;
		private Date updatedAt;
		private Boolean isFree;
		private Date createdAt;
		private String id;
		private Integer position;
		private String title;
		private Date deletedAt;
		private Boolean isOptional;

		public TrackResponseModelBuilder duration(Integer duration) {
			this.duration = duration;
			return this;
		}
		public TrackResponseModelBuilder courseId(String courseId) {
			this.courseId = courseId;
			return this;
		}
		public TrackResponseModelBuilder updatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
			return this;
		}
		public TrackResponseModelBuilder isFree(Boolean isFree) {
			this.isFree = isFree;
			return this;
		}
		public TrackResponseModelBuilder createdAt(Date createdAt) {
			this.createdAt = createdAt;
			return this;
		}
		public TrackResponseModelBuilder id(String id) {
			this.id = id;
			return this;
		}
		public TrackResponseModelBuilder position(Integer position) {
			this.position = position;
			return this;
		}
		public TrackResponseModelBuilder title(String title) {
			this.title = title;
			return this;
		}
		public TrackResponseModelBuilder deletedAt(Date deletedAt) {
			this.deletedAt = deletedAt;
			return this;
		}
		public TrackResponseModelBuilder isOptional(Boolean isOptional) {
			this.isOptional = isOptional;
			return this;
		}

		public TrackResponseModel build() {
			return new TrackResponseModel(this.duration, this.courseId, this.updatedAt, this.isFree, this.createdAt, this.id, this.position, this.title, this.deletedAt, this.isOptional);
		}

	}
}