package com.pironeer._week.mapper;

import com.pironeer._week.dto.request.TopicCreateRequest;
import com.pironeer._week.repository.domain.Topic;

import java.time.LocalDateTime;

public class TopicMapper {
    public static Topic from(TopicCreateRequest request) {
        LocalDateTime now = LocalDateTime.now();
        return Topic.builder()
                .title(request.title())
                .content(request.content())
                .createdAt(now)
                .updatedAt(now)
                .build();
    }
}
