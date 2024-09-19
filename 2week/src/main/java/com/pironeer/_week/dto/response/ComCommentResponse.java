package com.pironeer._week.dto.response;

import com.pironeer._week.repository.domain.ComComment;

import java.time.LocalDateTime;

public record ComCommentResponse (Long id, Long commentId, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
    public static ComCommentResponse of (ComComment comComment) {
        return new ComCommentResponse(comComment.getId(), comComment.getCommentId(), comComment.getContent(), comComment.getCreatedAt(), comComment.getUpdatedAt());
    }
}
