package com.pironeer._th.favorite.service;

import com.pironeer._th.board.repository.BoardRepository;
import com.pironeer._th.favorite.dto.request.FavoriteRequest;
import com.pironeer._th.favorite.dto.response.FavoriteResponse;
import com.pironeer._th.favorite.entity.Favorite;
import com.pironeer._th.favorite.repository.FavoriteRepository;
import com.pironeer._th.global.dto.response.result.SingleResult;
import com.pironeer._th.global.exception.CustomException;
import com.pironeer._th.global.exception.ErrorCode;
import com.pironeer._th.global.service.AuthService;
import com.pironeer._th.global.service.ResponseService;
import com.pironeer._th.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FavoriteService {

    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;
    private final FavoriteRepository favoriteRepository;

    public void addFavorite(FavoriteRequest request) {

        String memberId = request.memberId();
        if (favoriteRepository.existsByMemberIdAndBoardId(memberId, request.boardId())) {
            throw new CustomException(ErrorCode.ALREADY_FAVORITED);
        }

        Favorite favorite = Favorite.builder()
                .memberId(memberId)
                .boardId(request.boardId())
                .createdAt(java.time.LocalDateTime.now())
                .build();

        favoriteRepository.save(favorite);
    }

    public List<FavoriteResponse> getFavorites(String memberId) {
        List<Favorite> favorites = favoriteRepository.findByMemberId(memberId);

        return favorites.stream()
                .map(favorite -> {
                    return boardRepository.findById(favorite.getBoardId())
                            .map(board -> FavoriteResponse.of(favorite, board.getTitle()))
                            .orElseThrow(() -> new CustomException(ErrorCode.BOARD_NOT_FOUND));
                })
                .collect(Collectors.toList());
    }
}

