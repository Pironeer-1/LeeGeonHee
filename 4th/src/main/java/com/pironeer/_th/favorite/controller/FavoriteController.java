package com.pironeer._th.favorite.controller;

import com.pironeer._th.favorite.dto.request.FavoriteRequest;
import com.pironeer._th.favorite.dto.response.FavoriteResponse;
import com.pironeer._th.favorite.service.FavoriteService;
import com.pironeer._th.global.dto.response.JwtTokenSet;
import com.pironeer._th.global.dto.response.SuccessResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Favorite")
@RequestMapping("/api/favorites")
public class FavoriteController {

    private final FavoriteService favoriteService;

    @PostMapping("/add")
    @Operation(summary = "즐겨찾기추가")
    public SuccessResponse<String> addFavorite(@RequestBody FavoriteRequest request, HttpServletRequest req) {
        String memberId = (String) req.getAttribute("id");

        request = new FavoriteRequest(memberId, request.boardId());
        favoriteService.addFavorite(request);
        return SuccessResponse.ok("즐겨찾기에 추가되었습니다.");
    }

    @GetMapping("/{favoriteId}")
    @Operation(summary = "즐겨찾기 목록 조회")
    public SuccessResponse<List<FavoriteResponse>> getFavorites(HttpServletRequest req) {
        String memberId = (String) req.getAttribute("id");

        List<FavoriteResponse> favorites = favoriteService.getFavorites(memberId);
        return SuccessResponse.ok(favorites);
    }
}

