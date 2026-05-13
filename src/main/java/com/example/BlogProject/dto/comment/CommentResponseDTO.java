package com.example.BlogProject.dto.comment;

import java.time.LocalDateTime;

public class CommentResponseDTO {
    private Long id;
    private String content;
    private String username;
    private Long postId;
    private LocalDateTime createdAt;

    public CommentResponseDTO() {
    }

    public CommentResponseDTO(Long id, String content, String username, Long postId, LocalDateTime createdAt) {
        this.id = id;
        this.content = content;
        this.username = username;
        this.postId = postId;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getUsername() {
        return username;
    }

    public Long getPostId() {
        return postId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
