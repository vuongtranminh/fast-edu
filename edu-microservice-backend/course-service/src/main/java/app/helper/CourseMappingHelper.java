package app.helper;

import app.command.api.commands.CreateCourseCommand;
import app.command.api.commands.UpdateCourseCommand;
import app.command.api.model.CourseRequestModel;

import java.math.BigDecimal;
import java.util.Date;

public interface CourseMappingHelper {

    static CreateCourseCommand mapToCreateCommand(final CourseRequestModel model) {
        return CreateCourseCommand.builder()
                .lastCompletedAt(model.getLastCompletedAt())
                .isPublished(model.getIsPublished())
                .levelId(model.getLevelId())
                .icon(model.getIcon())
                .studentsCount(model.getStudentsCount())
                .description(model.getDescription())
                .createdAt(model.getCreatedAt())
                .video(model.getVideo())
                .title(model.getTitle())
                .isPreOrder(model.getIsPreOrder())
                .content(model.getContent())
                .videoUrl(model.getVideoUrl())
                .updatedAt(model.getUpdatedAt())
                .price(model.getPrice())
                .completedContent(model.getCompletedContent())
                .publishedAt(model.getPublishedAt())
                .slug(model.getSlug())
                .iconUrl(model.getIconUrl())
                .image(model.getImage())
                .imageUrl(model.getImageUrl())
                .oldPrice(model.getOldPrice())
                .certificateName(model.getCertificateName())
                .isSelling(model.getIsSelling())
                .priority(model.getPriority())
                .deletedAt(model.getDeletedAt())
                .preOrderPrice(model.getPreOrderPrice())
                .videoType(model.getVideoType())
                .isPro(model.getIsPro())
                .isCommingSoon(model.getIsCommingSoon())
                .build();
    }

    static UpdateCourseCommand mapToUpdateCommand(final CourseRequestModel model) {
        return UpdateCourseCommand.builder()
                .id(model.getId())
                .lastCompletedAt(model.getLastCompletedAt())
                .isPublished(model.getIsPublished())
                .levelId(model.getLevelId())
                .icon(model.getIcon())
                .studentsCount(model.getStudentsCount())
                .description(model.getDescription())
                .createdAt(model.getCreatedAt())
                .video(model.getVideo())
                .title(model.getTitle())
                .isPreOrder(model.getIsPreOrder())
                .content(model.getContent())
                .videoUrl(model.getVideoUrl())
                .updatedAt(model.getUpdatedAt())
                .price(model.getPrice())
                .completedContent(model.getCompletedContent())
                .publishedAt(model.getPublishedAt())
                .slug(model.getSlug())
                .iconUrl(model.getIconUrl())
                .image(model.getImage())
                .imageUrl(model.getImageUrl())
                .oldPrice(model.getOldPrice())
                .certificateName(model.getCertificateName())
                .isSelling(model.getIsSelling())
                .priority(model.getPriority())
                .deletedAt(model.getDeletedAt())
                .preOrderPrice(model.getPreOrderPrice())
                .videoType(model.getVideoType())
                .isPro(model.getIsPro())
                .isCommingSoon(model.getIsCommingSoon())
                .build();
    }
}
