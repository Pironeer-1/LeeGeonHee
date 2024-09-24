package com.pironeer._th.board.service;

import com.pironeer._th.board.dto.request.BoardCreateRequest;
import com.pironeer._th.board.dto.request.BoardUpdateRequest;
import com.pironeer._th.board.dto.response.BoardResponse;
import com.pironeer._th.board.entity.Board;
import com.pironeer._th.board.mapper.BoardMapper;
import com.pironeer._th.board.repository.BoardRepository;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void save(BoardCreateRequest request) {
        boardRepository.save(BoardMapper.from(request));
    }

    public BoardResponse findById(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BOARD NOT FOUND"));
        return BoardResponse.of(board);
    }

    public List<BoardResponse> findAll() {
        List<Board> topics = boardRepository.findAll();
        return topics.stream().map(BoardResponse::of).toList();
    }

    public BoardResponse update(BoardUpdateRequest request) {
        Board board = boardRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("BOARD NOT FOUND"));
        updateTitle(request.title(), board);
        updateContent(request.content(), board);
        board.setUpdatedAt(LocalDateTime.now());
        boardRepository.save(board);
        return BoardResponse.of(board);
    }

    private static void updateTitle(String title, Board board) {
        if (title != null && !title.isBlank()) {
            board.setTitle(title);
        }
    }

    private static void updateContent(String content, Board board) {
        if (content != null && !content.isBlank()) {
            board.setContent(content);
        }
    }

    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }
}
