package com.pironeer._th.favorite.repository;

import com.pironeer._th.favorite.entity.Favorite;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class FavoriteRepository {

    private final AtomicLong favoriteIdxGenerator = new AtomicLong(0);
    private final Map<Long, Favorite> favoriteMap = new HashMap<>();

    public Favorite save(Favorite favorite) {
        if (favorite.getId() == null) {
            Long id = favoriteIdxGenerator.incrementAndGet();
            favorite.setId(id);
            favoriteMap.put(id,favorite);

        } else {
            favoriteMap.replace(favorite.getId(), favorite);
        }
        return favorite;
    }

    public List<Favorite> findByMemberId(String memberId) {
        return favoriteMap.values().stream()
                .filter(favorite -> favorite.getMemberId().equals(memberId))
                .toList();
    }

    public boolean existsByMemberIdAndBoardId(String memberId, Long boardId) {
        return favoriteMap.values().stream()
                .anyMatch(favorite -> favorite.getMemberId().equals(memberId) && favorite.getBoardId().equals(boardId));
    }
}
