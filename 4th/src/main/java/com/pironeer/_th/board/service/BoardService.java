package com.pironeer._th.board.service;

import com.pironeer._th.board.dto.request.BoardCreateRequest;
import com.pironeer._th.board.dto.request.BoardUpdateRequest;
import com.pironeer._th.board.dto.response.BoardResponse;
import com.pironeer._th.board.entity.Board;
import com.pironeer._th.board.mapper.BoardMapper;
import com.pironeer._th.board.repository.BoardMemoryRepository;
import com.pironeer._th.global.dto.response.result.ListResult;
import com.pironeer._th.global.dto.response.result.SingleResult;
import com.pironeer._th.global.exception.CustomException;
import com.pironeer._th.global.exception.ErrorCode;
import com.pironeer._th.global.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMemoryRepository boardRepository;

    public SingleResult<Long> save(BoardCreateRequest request) {
        Board savedBoard =boardRepository.save(BoardMapper.from(request));
        return ResponseService.getSingleResult(savedBoard.getId());
    }

    public SingleResult<BoardResponse> findById(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.BOARD_NOT_FOUND));
        BoardResponse boardResponse = BoardResponse.of(board);
        return ResponseService.getSingleResult(boardResponse);
    }

    public ListResult<BoardResponse> findAll() {
        List<Board> boards = boardRepository.findAll();
        List<BoardResponse> list = boards.stream().map(BoardResponse::of).toList();
        return ResponseService.getListResult(list);
    }

    public BoardResponse update(BoardUpdateRequest request) {
        Board board = boardRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("BOARD NOT FOUND"));
        boardRepository.save(board.update(request));
        return BoardResponse.of(board);
    }


    public Long deleteById(Long id) {
        return boardRepository.deleteById(id);
    }
}
