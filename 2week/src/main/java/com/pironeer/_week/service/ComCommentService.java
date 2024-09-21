package com.pironeer._week.service;

import com.pironeer._week.dto.request.ComCommentCreateRequest;

import com.pironeer._week.dto.request.CommentUpdateRequest;
import com.pironeer._week.dto.response.ComCommentResponse;
import com.pironeer._week.mapper.ComCommentMapper;
import com.pironeer._week.repository.ComCommentRepository;
import com.pironeer._week.repository.CommentRepository;
import com.pironeer._week.repository.domain.ComComment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ComCommentService {
    private final ComCommentRepository comCommentRepository;
    private final CommentRepository commentRepository;

    public void save(ComCommentCreateRequest request) {
        comCommentRepository.save(ComCommentMapper.from(request));
    }

    public ComCommentResponse findById(Long id) {
        ComComment comComment = comCommentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("COMMENT NOT FOUND"));
        return ComCommentResponse.of(comComment);
    }

    public ComCommentResponse update(CommentUpdateRequest request) {
        ComComment comComment = comCommentRepository.findById(request.id())
                .orElseThrow(()-> new RuntimeException("COMCOMMENT NOT FOUND"));

        comComment.setContent(request.content());
        comComment.setUpdatedAt(LocalDateTime.now());
        comCommentRepository.save(comComment);
        return ComCommentResponse.of(comComment);
    }

    public void deleteById(Long id) {
        comCommentRepository.deleteById(id);
    }

    public List<ComCommentResponse> findAll() {
        List<ComComment> comComments = comCommentRepository.findAll();
        return comComments.stream().map(ComCommentResponse::of).toList();
    }
}
