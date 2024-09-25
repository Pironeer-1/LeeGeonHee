package com.pironeer._th.favorite.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Favorite {

    private Long id;
    private String memberId;
    private Long boardId;
    private LocalDateTime createdAt;

    @Builder

    public Favorite(String memberId, Long boardId, LocalDateTime createdAt) {
        this.memberId = memberId;
        this.boardId = boardId;
        this.createdAt = createdAt;
    }
}
