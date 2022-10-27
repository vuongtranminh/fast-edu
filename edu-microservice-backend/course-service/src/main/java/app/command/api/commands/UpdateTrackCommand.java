package app.command.api.commands;

import java.io.Serializable;

import app.contracts.BaseUpdateCommand;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import java.util.Date;

public class UpdateTrackCommand extends BaseUpdateCommand implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer duration;
	private String courseId;
	private Date updatedAt;
	private Boolean isFree;
	private Date createdAt;
	private Integer position;
	private String title;
	private Date deletedAt;
	private Boolean isOptional;

	public UpdateTrackCommand(String id) {
		super(id);
	}

	public UpdateTrackCommand(Integer duration, String courseId, Date updatedAt, Boolean isFree, Date createdAt, String id, Integer position, String title, Date deletedAt, Boolean isOptional) {
		super(id);
		this.duration = duration;
		this.courseId = courseId;
		this.updatedAt = updatedAt;
		this.isFree = isFree;
		this.createdAt = createdAt;
		this.position = position;
		this.title = title;
		this.deletedAt = deletedAt;
		this.isOptional = isOptional;
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

	public static UpdateTrackCommandBuilder builder() {
		return new UpdateTrackCommandBuilder();
	}
	public static class UpdateTrackCommandBuilder {

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

		public UpdateTrackCommandBuilder duration(Integer duration) {
			this.duration = duration;
			return this;
		}
		public UpdateTrackCommandBuilder courseId(String courseId) {
			this.courseId = courseId;
			return this;
		}
		public UpdateTrackCommandBuilder updatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
			return this;
		}
		public UpdateTrackCommandBuilder isFree(Boolean isFree) {
			this.isFree = isFree;
			return this;
		}
		public UpdateTrackCommandBuilder createdAt(Date createdAt) {
			this.createdAt = createdAt;
			return this;
		}
		public UpdateTrackCommandBuilder id(String id) {
			this.id = id;
			return this;
		}
		public UpdateTrackCommandBuilder position(Integer position) {
			this.position = position;
			return this;
		}
		public UpdateTrackCommandBuilder title(String title) {
			this.title = title;
			return this;
		}
		public UpdateTrackCommandBuilder deletedAt(Date deletedAt) {
			this.deletedAt = deletedAt;
			return this;
		}
		public UpdateTrackCommandBuilder isOptional(Boolean isOptional) {
			this.isOptional = isOptional;
			return this;
		}

		public UpdateTrackCommand build() {
			return new UpdateTrackCommand(this.duration, this.courseId, this.updatedAt, this.isFree, this.createdAt, this.id, this.position, this.title, this.deletedAt, this.isOptional);
		}

	}
}