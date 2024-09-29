package com.pironeer._th.board.dto.response;

import com.pironeer._th.board.entity.Board;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record BoardResponse (
        @NotNull
        @Schema(description = "Board ID", example = "1")
        Long id,
        @NotBlank
        @Schema(description = "Board 제목", example = "제목입니다.")
        String title,
        @Schema(description = "Board 내용", example = "내용입니다.")
        String content,
        @NotNull
        @Schema(description = "Board 생성 시간", example = "2024-09-24 00:00:00")
        LocalDateTime createdAt,
        @NotNull
        @Schema(description = "Board 수정 시간", example = "2024-09-25 00:00:00")
        LocalDateTime updatedAt) {

    public static BoardResponse of(Board board) {
        return BoardResponse.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .createdAt(board.getCreatedAt())
                .updatedAt(board.getUpdatedAt())
                .build();
    }
}
