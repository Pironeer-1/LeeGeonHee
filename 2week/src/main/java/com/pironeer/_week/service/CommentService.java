package com.pironeer._week.service;


import com.pironeer._week.dto.request.CommentCreateRequest;
import com.pironeer._week.dto.request.CommentUpdateRequest;
import com.pironeer._week.dto.response.CommentResponse;
import com.pironeer._week.mapper.CommentMapper;
import com.pironeer._week.mapper.TopicMapper;
import com.pironeer._week.repository.CommentRepository;
import com.pironeer._week.repository.TopicRepository;
import com.pironeer._week.repository.domain.Comment;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final TopicRepository topicRepository;

    public void save(CommentCreateRequest request) {
        commentRepository.save(CommentMapper.from(request));
    }

    public CommentResponse findById(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("COMMENT NOT FOUND"));
        return CommentResponse.of(comment);
    }

    public CommentResponse update(CommentUpdateRequest request) {
        Comment comment = commentRepository.findById(request.id())
                .orElseThrow(()-> new RuntimeException("COMMENT NOT FOUND"));
        comment.setContent(request.content());
        comment.setUpdatedAt(LocalDateTime.now());
        commentRepository.save(comment);
        return CommentResponse.of(comment);
    }

    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }
}
