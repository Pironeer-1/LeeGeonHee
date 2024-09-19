package com.pironeer._week.mapper;

import com.pironeer._week.dto.request.CommentCreateRequest;
import com.pironeer._week.repository.domain.Comment;

import java.time.LocalDateTime;

public class CommentMapper {
    public static Comment from(CommentCreateRequest request) {
        LocalDateTime now = LocalDateTime.now();
        return Comment.builder()
                .topicId(request.topicId())
                .content(request.content())
                .createdAt(now)
                .updatedAt(now)
                .build();
    }
}
