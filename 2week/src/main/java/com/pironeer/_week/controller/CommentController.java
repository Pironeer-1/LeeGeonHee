package com.pironeer._week.controller;


import com.pironeer._week.dto.request.CommentCreateRequest;
import com.pironeer._week.dto.request.CommentUpdateRequest;
import com.pironeer._week.dto.request.TopicUpdateRequest;
import com.pironeer._week.dto.response.CommentResponse;
import com.pironeer._week.dto.response.TopicResponse;
import com.pironeer._week.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    @Operation(summary = "댓글 작성")
    public ResponseEntity<?> create(@RequestBody CommentCreateRequest request) {
        commentService.save(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{commentId}")
    @Operation(summary = "댓글 단건 조회")
    public ResponseEntity<CommentResponse> read(@PathVariable("commentId") Long id) {
        CommentResponse response = commentService.findById(id);
        return ResponseEntity.ok().body(response);
    }

    @PatchMapping
    @Operation(summary = "댓글 수정")
    public ResponseEntity<CommentResponse> update(@RequestBody CommentUpdateRequest request) {
        CommentResponse response = commentService.update(request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{commentId}")
    @Operation(summary = "댓글 삭제")
    public ResponseEntity<?> remove(@PathVariable("commentId") Long id) {
        commentService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
