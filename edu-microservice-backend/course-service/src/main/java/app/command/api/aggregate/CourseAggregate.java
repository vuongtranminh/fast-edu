package app.command.api.aggregate;

import app.command.api.commands.CreateCourseCommand;
import app.command.api.commands.DeleteCourseCommand;
import app.command.api.commands.UpdateCourseCommand;
import app.command.api.events.CourseCreatedEvent;
import app.command.api.events.CourseDeletedEvent;
import app.command.api.events.CourseUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Date;

@Aggregate
public class CourseAggregate {

    @AggregateIdentifier
    private String id;
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

    public CourseAggregate() {
    }

    @CommandHandler
    public CourseAggregate(CreateCourseCommand command) {
        //You can perform all the validations
        CourseCreatedEvent event = new CourseCreatedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(UpdateCourseCommand command) {
        CourseUpdatedEvent event = new CourseUpdatedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(DeleteCourseCommand command) {
        CourseDeletedEvent event = new CourseDeletedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CourseCreatedEvent event) {
        this.id = event.getId();
        this.lastCompletedAt = event.getLastCompletedAt();
        this.isPublished = event.getIsPublished();
        this.levelId = event.getLevelId();
        this.icon = event.getIcon();
        this.studentsCount = event.getStudentsCount();
        this.description = event.getDescription();
        this.createdAt = event.getCreatedAt();
        this.video = event.getVideo();
        this.title = event.getTitle();
        this.isPreOrder = event.getIsPreOrder();
        this.content = event.getContent();
        this.videoUrl = event.getVideoUrl();
        this.updatedAt = event.getUpdatedAt();
        this.price = event.getPrice();
        this.completedContent = event.getCompletedContent();
        this.publishedAt = event.getPublishedAt();
        this.slug = event.getSlug();
        this.iconUrl = event.getIconUrl();
        this.image = event.getImage();
        this.imageUrl = event.getImageUrl();
        this.oldPrice = event.getOldPrice();
        this.certificateName = event.getCertificateName();
        this.isSelling = event.getIsSelling();
        this.priority = event.getPriority();
        this.deletedAt = event.getDeletedAt();
        this.preOrderPrice = event.getPreOrderPrice();
        this.videoType = event.getVideoType();
        this.isPro = event.getIsPro();
        this.isCommingSoon = event.getIsCommingSoon();
    }

    @EventSourcingHandler
    public void on(CourseUpdatedEvent event) {
        this.id = event.getId();
        this.lastCompletedAt = event.getLastCompletedAt();
        this.isPublished = event.getIsPublished();
        this.levelId = event.getLevelId();
        this.icon = event.getIcon();
        this.studentsCount = event.getStudentsCount();
        this.description = event.getDescription();
        this.createdAt = event.getCreatedAt();
        this.video = event.getVideo();
        this.title = event.getTitle();
        this.isPreOrder = event.getIsPreOrder();
        this.content = event.getContent();
        this.videoUrl = event.getVideoUrl();
        this.updatedAt = event.getUpdatedAt();
        this.price = event.getPrice();
        this.completedContent = event.getCompletedContent();
        this.publishedAt = event.getPublishedAt();
        this.slug = event.getSlug();
        this.iconUrl = event.getIconUrl();
        this.image = event.getImage();
        this.imageUrl = event.getImageUrl();
        this.oldPrice = event.getOldPrice();
        this.certificateName = event.getCertificateName();
        this.isSelling = event.getIsSelling();
        this.priority = event.getPriority();
        this.deletedAt = event.getDeletedAt();
        this.preOrderPrice = event.getPreOrderPrice();
        this.videoType = event.getVideoType();
        this.isPro = event.getIsPro();
        this.isCommingSoon = event.getIsCommingSoon();
    }

    @EventSourcingHandler
    public void on(CourseDeletedEvent event) {
        this.id = event.getId();
    }

}
