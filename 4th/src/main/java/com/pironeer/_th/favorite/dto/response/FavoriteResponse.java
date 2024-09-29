package com.pironeer._th.favorite.dto.response;

import com.pironeer._th.favorite.entity.Favorite;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record FavoriteResponse(

        @NotNull
        @Schema(description = "즐겨찾기 id", example = "100")
        Long favoriteId,

        @NotBlank
        @Schema(description = "회원 id", example = "1")
        String memberId,

        @NotBlank
        @Schema(description = "Board id", example = "10.")
        Long boardId,

        @NotNull
        @Schema(description = "게시글 제목", example = "Spring Boot 가보잣")
        String boardTitle,

        @NotNull
        @Schema(description = "즐겨찾기 추가 시간", example = "2024-09-25 00:00:00")
        LocalDateTime createdAt) {

    public static FavoriteResponse of(Favorite favorite, String boardTitle) {
        return FavoriteResponse.builder()
                .favoriteId(favorite.getId())
                .memberId(favorite.getMemberId())
                .boardId(favorite.getBoardId())
                .boardTitle(boardTitle)
                .createdAt(favorite.getCreatedAt())
                .build();
    }
}
