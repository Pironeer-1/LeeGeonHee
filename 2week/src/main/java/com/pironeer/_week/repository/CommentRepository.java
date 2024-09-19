package com.pironeer._week.repository;

import com.pironeer._week.repository.domain.Comment;
import com.pironeer._week.repository.domain.Topic;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CommentRepository {
    private final AtomicLong commentIdxGenerator = new AtomicLong();
    private final Map<Long, Comment> commentMap = new HashMap<>();

    public void save(Comment comment) {
        if(comment.getId() == null) {
            Long id = commentIdxGenerator.incrementAndGet();
            comment.setId(id);
            commentMap.put(id, comment);
        } else {
            commentMap.replace(comment.getId(), comment);
        }
    }

    public Optional<Comment> findById(Long id) {
        Assert.notNull(id, "ID MUST NOT BE NULL");
        return Optional.of(commentMap.get(id));
    }

    public void deleteById(Long id) {
        Assert.notNull(id, "ID MUST NOT BE NULL");
        commentMap.remove(id);
    }
}
