package com.pironeer._week.controller;



import com.pironeer._week.dto.request.ComCommentCreateRequest;
import com.pironeer._week.dto.request.CommentUpdateRequest;
import com.pironeer._week.dto.response.ComCommentResponse;
import com.pironeer._week.repository.ComCommentRepository;
import com.pironeer._week.service.ComCommentService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/com_comment")
public class ComCommentController {
    private final ComCommentService comCommentService ;

    @PostMapping
    @Operation(summary = "대댓글 작성")
    public ResponseEntity<?> create(@RequestBody ComCommentCreateRequest request) {
        comCommentService.save(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{comCommentId}")
    @Operation(summary = "대댓글 단건 조회")
    public ResponseEntity<ComCommentResponse> read(@PathVariable("comCommentId") Long id) {
        ComCommentResponse response = comCommentService.findById(id);
        return ResponseEntity.ok().body(response);
    }

    @PatchMapping
    @Operation(summary = "대댓글 수정")
    public ResponseEntity<ComCommentResponse> update(@RequestBody CommentUpdateRequest request) {
        ComCommentResponse response = comCommentService.update(request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{comCommentId}")
    @Operation(summary = "대댓글 삭제")
    public ResponseEntity<?> remove(@PathVariable("comCommentId") Long id) {
        comCommentService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
