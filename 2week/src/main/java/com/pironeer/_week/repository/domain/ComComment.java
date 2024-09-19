package com.pironeer._week.repository.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@Setter
public class ComComment {
    private Long id;
    private Long commentId;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public ComComment(Long id, Long commentId, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.commentId = commentId;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
