package com.pironeer._week.mapper;

import com.pironeer._week.dto.request.ComCommentCreateRequest;
import com.pironeer._week.dto.request.CommentCreateRequest;
import com.pironeer._week.repository.domain.ComComment;

import java.time.LocalDateTime;

public class ComCommentMapper {
    public static ComComment from(ComCommentCreateRequest request) {
        LocalDateTime now = LocalDateTime.now();
        return ComComment.builder()
                .commentId(request.commentId())
                .content(request.content())
                .createdAt(now)
                .updatedAt(now)
                .build();
    }
}
