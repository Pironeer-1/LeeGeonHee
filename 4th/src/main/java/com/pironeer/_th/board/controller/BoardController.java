package com.pironeer._th.board.controller;

import com.pironeer._th.board.dto.request.BoardCreateRequest;
import com.pironeer._th.board.dto.request.BoardUpdateRequest;
import com.pironeer._th.board.dto.response.BoardResponse;
import com.pironeer._th.board.service.BoardService;
import com.pironeer._th.global.dto.response.SuccessResponse;
import com.pironeer._th.global.dto.response.result.ListResult;
import com.pironeer._th.global.dto.response.result.SingleResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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
    public SuccessResponse<SingleResult<Long>> create(
            @RequestAttribute("id") String userId, @Valid @RequestBody BoardCreateRequest request) {
        System.out.println(userId);

        SingleResult<Long> save = boardService.save(request);
        return SuccessResponse.ok(save);
    }

    @GetMapping("/{boardId}")
    @Operation(summary = "Board 단건 조회")
    public SuccessResponse<SingleResult<BoardResponse>> read(@PathVariable("boardId") Long id) {
        SingleResult<BoardResponse> result = boardService.findById(id);
        return SuccessResponse.ok(result);
    }

    @GetMapping()
    @Operation(summary = "Board 전체 조회")
    public SuccessResponse<ListResult<BoardResponse>> readAll() {
        ListResult<BoardResponse> result = boardService.findAll();
        return SuccessResponse.ok(result);
    }

    @PutMapping
    @Operation(summary = "Board 수정")
    public ResponseEntity<BoardResponse> update(@RequestBody BoardUpdateRequest request) {
        BoardResponse response = boardService.update(request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{boardId}")
    @Operation(summary = "Board 삭제")
    public ResponseEntity<?> remove(@PathVariable("boardId") Long id) {
        Long deletedId = boardService.deleteById(id);
        return ResponseEntity.ok().body(deletedId);
    }
}
