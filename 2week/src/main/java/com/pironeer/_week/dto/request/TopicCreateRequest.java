package com.pironeer._week.dto.request;

import java.time.LocalDateTime;

public record TopicCreateRequest (String title, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
}
