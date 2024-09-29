package com.pironeer._th.board.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BoardUpdateRequest (
        @NotNull
        @Schema(description = "Board ID", example = "1")
        Long id,
        @NotBlank
        @Schema(description = "수정할 Board 제목", example = "제목을 수정합니다.")
        String title,
        @Schema(description = "수정할 Board 내용", example = "내용을 수정합니다.")
        String content) {
}
