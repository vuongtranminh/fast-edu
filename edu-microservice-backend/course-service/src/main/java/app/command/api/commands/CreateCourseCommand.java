package app.command.api.commands;

import java.io.Serializable;

import app.contracts.BaseCommand;
import app.contracts.BaseCreateCommand;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import java.util.Date;
import java.math.BigDecimal;

public class CreateCourseCommand extends BaseCreateCommand implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date lastCompletedAt;
	private Boolean isPublished;
	private Integer levelId;
	private String icon;
	private Integer studentsCount;
	private String description;
	private Date createdAt;
	private String video;
	private String title;
	private Boolean isPreOrder;
	private String content;
	private String videoUrl;
	private Date updatedAt;
	private BigDecimal price;
	private String completedContent;
	private Date publishedAt;
	private String slug;
	private String iconUrl;
	private String image;
	private String imageUrl;
	private BigDecimal oldPrice;
	private String certificateName;
	private Boolean isSelling;
	private Integer priority;
	private Date deletedAt;
	private BigDecimal preOrderPrice;
	private String videoType;
	private Boolean isPro;
	private Boolean isCommingSoon;

	public CreateCourseCommand() {
		super();
	}

	public CreateCourseCommand(Date lastCompletedAt, Boolean isPublished, Integer levelId, String icon, Integer studentsCount, String description, Date createdAt, String video, String title, Boolean isPreOrder, String content, String videoUrl, Date updatedAt, BigDecimal price, String completedContent, Date publishedAt, String slug, String iconUrl, String image, String imageUrl, BigDecimal oldPrice, String certificateName, Boolean isSelling, Integer priority, Date deletedAt, BigDecimal preOrderPrice, String videoType, Boolean isPro, Boolean isCommingSoon) {
		super();
		this.lastCompletedAt = lastCompletedAt;
		this.isPublished = isPublished;
		this.levelId = levelId;
		this.icon = icon;
		this.studentsCount = studentsCount;
		this.description = description;
		this.createdAt = createdAt;
		this.video = video;
		this.title = title;
		this.isPreOrder = isPreOrder;
		this.content = content;
		this.videoUrl = videoUrl;
		this.updatedAt = updatedAt;
		this.price = price;
		this.completedContent = completedContent;
		this.publishedAt = publishedAt;
		this.slug = slug;
		this.iconUrl = iconUrl;
		this.image = image;
		this.imageUrl = imageUrl;
		this.oldPrice = oldPrice;
		this.certificateName = certificateName;
		this.isSelling = isSelling;
		this.priority = priority;
		this.deletedAt = deletedAt;
		this.preOrderPrice = preOrderPrice;
		this.videoType = videoType;
		this.isPro = isPro;
		this.isCommingSoon = isCommingSoon;
	}

	public Date getLastCompletedAt() {
		return lastCompletedAt;
	}
	public void setLastCompletedAt(Date lastCompletedAt) {
		this.lastCompletedAt = lastCompletedAt;
	}
	public Boolean getIsPublished() {
		return isPublished;
	}
	public void setIsPublished(Boolean isPublished) {
		this.isPublished = isPublished;
	}
	public Integer getLevelId() {
		return levelId;
	}
	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon == null ? null : icon.trim();
	}
	public Integer getStudentsCount() {
		return studentsCount;
	}
	public void setStudentsCount(Integer studentsCount) {
		this.studentsCount = studentsCount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video == null ? null : video.trim();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}
	public Boolean getIsPreOrder() {
		return isPreOrder;
	}
	public void setIsPreOrder(Boolean isPreOrder) {
		this.isPreOrder = isPreOrder;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl == null ? null : videoUrl.trim();
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getCompletedContent() {
		return completedContent;
	}
	public void setCompletedContent(String completedContent) {
		this.completedContent = completedContent == null ? null : completedContent.trim();
	}
	public Date getPublishedAt() {
		return publishedAt;
	}
	public void setPublishedAt(Date publishedAt) {
		this.publishedAt = publishedAt;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug == null ? null : slug.trim();
	}
	public String getIconUrl() {
		return iconUrl;
	}
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl == null ? null : iconUrl.trim();
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image == null ? null : image.trim();
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl == null ? null : imageUrl.trim();
	}
	public BigDecimal getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(BigDecimal oldPrice) {
		this.oldPrice = oldPrice;
	}
	public String getCertificateName() {
		return certificateName;
	}
	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName == null ? null : certificateName.trim();
	}
	public Boolean getIsSelling() {
		return isSelling;
	}
	public void setIsSelling(Boolean isSelling) {
		this.isSelling = isSelling;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Date getDeletedAt() {
		return deletedAt;
	}
	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}
	public BigDecimal getPreOrderPrice() {
		return preOrderPrice;
	}
	public void setPreOrderPrice(BigDecimal preOrderPrice) {
		this.preOrderPrice = preOrderPrice;
	}
	public String getVideoType() {
		return videoType;
	}
	public void setVideoType(String videoType) {
		this.videoType = videoType == null ? null : videoType.trim();
	}
	public Boolean getIsPro() {
		return isPro;
	}
	public void setIsPro(Boolean isPro) {
		this.isPro = isPro;
	}
	public Boolean getIsCommingSoon() {
		return isCommingSoon;
	}
	public void setIsCommingSoon(Boolean isCommingSoon) {
		this.isCommingSoon = isCommingSoon;
	}

	public static CreateCourseCommandBuilder builder() {
		return new CreateCourseCommandBuilder();
	}
	public static class CreateCourseCommandBuilder {

		private Date lastCompletedAt;
		private Boolean isPublished;
		private Integer levelId;
		private String icon;
		private Integer studentsCount;
		private String description;
		private Date createdAt;
		private String video;
		private String title;
		private Boolean isPreOrder;
		private String content;
		private String videoUrl;
		private Date updatedAt;
		private BigDecimal price;
		private String completedContent;
		private Date publishedAt;
		private String slug;
		private String iconUrl;
		private String image;
		private String imageUrl;
		private BigDecimal oldPrice;
		private String certificateName;
		private Boolean isSelling;
		private Integer priority;
		private Date deletedAt;
		private BigDecimal preOrderPrice;
		private String videoType;
		private Boolean isPro;
		private Boolean isCommingSoon;

		public CreateCourseCommandBuilder lastCompletedAt(Date lastCompletedAt) {
			this.lastCompletedAt = lastCompletedAt;
			return this;
		}
		public CreateCourseCommandBuilder isPublished(Boolean isPublished) {
			this.isPublished = isPublished;
			return this;
		}
		public CreateCourseCommandBuilder levelId(Integer levelId) {
			this.levelId = levelId;
			return this;
		}
		public CreateCourseCommandBuilder icon(String icon) {
			this.icon = icon;
			return this;
		}
		public CreateCourseCommandBuilder studentsCount(Integer studentsCount) {
			this.studentsCount = studentsCount;
			return this;
		}
		public CreateCourseCommandBuilder description(String description) {
			this.description = description;
			return this;
		}
		public CreateCourseCommandBuilder createdAt(Date createdAt) {
			this.createdAt = createdAt;
			return this;
		}
		public CreateCourseCommandBuilder video(String video) {
			this.video = video;
			return this;
		}
		public CreateCourseCommandBuilder title(String title) {
			this.title = title;
			return this;
		}
		public CreateCourseCommandBuilder isPreOrder(Boolean isPreOrder) {
			this.isPreOrder = isPreOrder;
			return this;
		}
		public CreateCourseCommandBuilder content(String content) {
			this.content = content;
			return this;
		}
		public CreateCourseCommandBuilder videoUrl(String videoUrl) {
			this.videoUrl = videoUrl;
			return this;
		}
		public CreateCourseCommandBuilder updatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
			return this;
		}
		public CreateCourseCommandBuilder price(BigDecimal price) {
			this.price = price;
			return this;
		}
		public CreateCourseCommandBuilder completedContent(String completedContent) {
			this.completedContent = completedContent;
			return this;
		}
		public CreateCourseCommandBuilder publishedAt(Date publishedAt) {
			this.publishedAt = publishedAt;
			return this;
		}
		public CreateCourseCommandBuilder slug(String slug) {
			this.slug = slug;
			return this;
		}
		public CreateCourseCommandBuilder iconUrl(String iconUrl) {
			this.iconUrl = iconUrl;
			return this;
		}
		public CreateCourseCommandBuilder image(String image) {
			this.image = image;
			return this;
		}
		public CreateCourseCommandBuilder imageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
			return this;
		}
		public CreateCourseCommandBuilder oldPrice(BigDecimal oldPrice) {
			this.oldPrice = oldPrice;
			return this;
		}
		public CreateCourseCommandBuilder certificateName(String certificateName) {
			this.certificateName = certificateName;
			return this;
		}
		public CreateCourseCommandBuilder isSelling(Boolean isSelling) {
			this.isSelling = isSelling;
			return this;
		}
		public CreateCourseCommandBuilder priority(Integer priority) {
			this.priority = priority;
			return this;
		}
		public CreateCourseCommandBuilder deletedAt(Date deletedAt) {
			this.deletedAt = deletedAt;
			return this;
		}
		public CreateCourseCommandBuilder preOrderPrice(BigDecimal preOrderPrice) {
			this.preOrderPrice = preOrderPrice;
			return this;
		}
		public CreateCourseCommandBuilder videoType(String videoType) {
			this.videoType = videoType;
			return this;
		}
		public CreateCourseCommandBuilder isPro(Boolean isPro) {
			this.isPro = isPro;
			return this;
		}
		public CreateCourseCommandBuilder isCommingSoon(Boolean isCommingSoon) {
			this.isCommingSoon = isCommingSoon;
			return this;
		}

		public CreateCourseCommand build() {
			return new CreateCourseCommand(this.lastCompletedAt, this.isPublished, this.levelId, this.icon, this.studentsCount, this.description, this.createdAt, this.video, this.title, this.isPreOrder, this.content, this.videoUrl, this.updatedAt, this.price, this.completedContent, this.publishedAt, this.slug, this.iconUrl, this.image, this.imageUrl, this.oldPrice, this.certificateName, this.isSelling, this.priority, this.deletedAt, this.preOrderPrice, this.videoType, this.isPro, this.isCommingSoon);
		}

	}
}