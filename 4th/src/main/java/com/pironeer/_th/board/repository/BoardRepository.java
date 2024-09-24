    package com.pironeer._th.board.repository;

    import com.pironeer._th.board.entity.Board;
    import org.springframework.stereotype.Repository;
    import org.springframework.util.Assert;

    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;
    import java.util.Optional;
    import java.util.concurrent.atomic.AtomicLong;


    @Repository
    public class BoardRepository {

        private final AtomicLong boardIdxGenerator = new AtomicLong(0);
        private final Map<Long, Board> boardMap = new HashMap<>();


        public Board save(Board board) {
            if(board.getId() == null) {
                Long id = boardIdxGenerator.incrementAndGet();
                board.setId(id);
                boardMap.put(id, board);
                return board;
            } else {
                boardMap.replace(board.getId(), board);
                return board;
            }
        }


        public Optional<Board> findById(Long id) {
            Assert.notNull(id, "ID MUST NOT BE NULL");
            return Optional.of(boardMap.get(id));
        }

        public List<Board> findAll() {
            return boardMap.values().stream().toList();
        }


        public Long deleteById(Long id) {
            Assert.notNull(id, "ID MUST NOT BE NULL");
            boardMap.remove(id);
            return id;
        }
    }
