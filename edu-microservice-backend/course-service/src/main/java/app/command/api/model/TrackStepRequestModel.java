package app.command.api.model;

import java.io.Serializable;
import java.util.Date;

public class TrackStepRequestModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private Date updatedAt;
	private Boolean isBookmarked;
	private Boolean isPublished;
	private String stepType;
	private String trackId;
	private String trackStepLevelId;
	private Integer position;
	private String stepId;
	private Date publishedAt;
	private Date deletedAt;

	public TrackStepRequestModel() { }

	public TrackStepRequestModel(Date updatedAt, Boolean isBookmarked, Boolean isPublished, String stepType, String trackId, String trackStepLevelId, String id, Integer position, String stepId, Date publishedAt, Date deletedAt) {
		this.updatedAt = updatedAt;
		this.isBookmarked = isBookmarked;
		this.isPublished = isPublished;
		this.stepType = stepType;
		this.trackId = trackId;
		this.trackStepLevelId = trackStepLevelId;
		this.id = id;
		this.position = position;
		this.stepId = stepId;
		this.publishedAt = publishedAt;
		this.deletedAt = deletedAt;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Boolean getIsBookmarked() {
		return isBookmarked;
	}
	public void setIsBookmarked(Boolean isBookmarked) {
		this.isBookmarked = isBookmarked;
	}
	public Boolean getIsPublished() {
		return isPublished;
	}
	public void setIsPublished(Boolean isPublished) {
		this.isPublished = isPublished;
	}
	public String getStepType() {
		return stepType;
	}
	public void setStepType(String stepType) {
		this.stepType = stepType == null ? null : stepType.trim();
	}
	public String getTrackId() {
		return trackId;
	}
	public void setTrackId(String trackId) {
		this.trackId = trackId == null ? null : trackId.trim();
	}
	public String getTrackStepLevelId() {
		return trackStepLevelId;
	}
	public void setTrackStepLevelId(String trackStepLevelId) {
		this.trackStepLevelId = trackStepLevelId == null ? null : trackStepLevelId.trim();
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	public String getStepId() {
		return stepId;
	}
	public void setStepId(String stepId) {
		this.stepId = stepId == null ? null : stepId.trim();
	}
	public Date getPublishedAt() {
		return publishedAt;
	}
	public void setPublishedAt(Date publishedAt) {
		this.publishedAt = publishedAt;
	}
	public Date getDeletedAt() {
		return deletedAt;
	}
	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	public static TrackStepRequestModelBuilder builder() {
		return new TrackStepRequestModelBuilder();
	}
	public static class TrackStepRequestModelBuilder {

		private Date updatedAt;
		private Boolean isBookmarked;
		private Boolean isPublished;
		private String stepType;
		private String trackId;
		private String trackStepLevelId;
		private String id;
		private Integer position;
		private String stepId;
		private Date publishedAt;
		private Date deletedAt;

		public TrackStepRequestModelBuilder updatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
			return this;
		}
		public TrackStepRequestModelBuilder isBookmarked(Boolean isBookmarked) {
			this.isBookmarked = isBookmarked;
			return this;
		}
		public TrackStepRequestModelBuilder isPublished(Boolean isPublished) {
			this.isPublished = isPublished;
			return this;
		}
		public TrackStepRequestModelBuilder stepType(String stepType) {
			this.stepType = stepType;
			return this;
		}
		public TrackStepRequestModelBuilder trackId(String trackId) {
			this.trackId = trackId;
			return this;
		}
		public TrackStepRequestModelBuilder trackStepLevelId(String trackStepLevelId) {
			this.trackStepLevelId = trackStepLevelId;
			return this;
		}
		public TrackStepRequestModelBuilder id(String id) {
			this.id = id;
			return this;
		}
		public TrackStepRequestModelBuilder position(Integer position) {
			this.position = position;
			return this;
		}
		public TrackStepRequestModelBuilder stepId(String stepId) {
			this.stepId = stepId;
			return this;
		}
		public TrackStepRequestModelBuilder publishedAt(Date publishedAt) {
			this.publishedAt = publishedAt;
			return this;
		}
		public TrackStepRequestModelBuilder deletedAt(Date deletedAt) {
			this.deletedAt = deletedAt;
			return this;
		}

		public TrackStepRequestModel build() {
			return new TrackStepRequestModel(this.updatedAt, this.isBookmarked, this.isPublished, this.stepType, this.trackId, this.trackStepLevelId, this.id, this.position, this.stepId, this.publishedAt, this.deletedAt);
		}

	}
}