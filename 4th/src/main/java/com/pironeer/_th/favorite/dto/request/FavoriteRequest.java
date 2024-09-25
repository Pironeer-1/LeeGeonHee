package com.pironeer._th.favorite.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record FavoriteRequest (

        @NotNull
        @Schema(description = "회원 id", example = "id")
        String memberId,

        @NotNull
        @Schema(description = "board id", example = "1")
        Long boardId
) {

}
