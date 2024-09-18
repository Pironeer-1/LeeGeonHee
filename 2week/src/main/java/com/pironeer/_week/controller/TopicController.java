package com.pironeer._week.controller;


import com.pironeer._week.dto.request.TopicCreateRequest;
import com.pironeer._week.dto.request.TopicUpdateRequest;
import com.pironeer._week.dto.response.TopicResponse;
import com.pironeer._week.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/topic")
public class TopicController {
    private final TopicService topicService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TopicCreateRequest request) {
        topicService.save(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{topicId}")
    public ResponseEntity<TopicResponse> read(@PathVariable("topicId") Long id) {
        TopicResponse response = topicService.findById(id);
        return ResponseEntity.ok().body(response);
    }

    public ResponseEntity<List<TopicResponse>> readAll() {
        List<TopicResponse> responses = topicService.findAll();
        return ResponseEntity.ok().body(responses);
    }

    @PatchMapping
    public ResponseEntity<TopicResponse> update(@RequestBody TopicUpdateRequest request) {
        TopicResponse response = topicService.update(request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{topicId}")
    public ResponseEntity<?> remove(@PathVariable("topicId") Long id) {
        topicService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
