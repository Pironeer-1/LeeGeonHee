package com.pironeer._week.dto.response;

import com.pironeer._week.repository.domain.Comment;

import java.time.LocalDateTime;

public record CommentResponse (Long id, Long topicId, String content, LocalDateTime createdAt, LocalDateTime updatedAt){
    public static CommentResponse of (Comment comment) {
        return new CommentResponse(comment.getId(), comment.getTopicId(), comment.getContent(), comment.getCreatedAt(), comment.getUpdatedAt());
    }
}
