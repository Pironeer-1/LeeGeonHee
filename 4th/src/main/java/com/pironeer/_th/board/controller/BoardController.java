package com.pironeer._th.board.controller;

import com.pironeer._th.board.dto.request.BoardCreateRequest;
import com.pironeer._th.board.dto.request.BoardUpdateRequest;
import com.pironeer._th.board.dto.response.BoardResponse;
import com.pironeer._th.board.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Tag(name = "Board")
@RequestMapping("/api/board")
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    @Operation(summary = "Board 작성")
    public ResponseEntity<?> create(@RequestBody BoardCreateRequest request) {
        boardService.save(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{boardId}")
    @Operation(summary = "Board 단건 조회")
    public ResponseEntity<BoardResponse> read(@PathVariable("boardId") Long id) {
        BoardResponse response = boardService.findById(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    @Operation(summary = "Board 전체 조회")
    public ResponseEntity<List<BoardResponse>> readAll() {
        List<BoardResponse> responses = boardService.findAll();
        return ResponseEntity.ok().body(responses);
    }

    @PatchMapping
    @Operation(summary = "Board 수정")
    public ResponseEntity<BoardResponse> update(@RequestBody BoardUpdateRequest request) {
        BoardResponse response = boardService.update(request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{boardId}")
    @Operation(summary = "Board 삭제")
    public ResponseEntity<?> remove(@PathVariable("boardId") Long id) {
        boardService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
