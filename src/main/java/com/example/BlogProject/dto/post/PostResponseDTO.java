package com.example.BlogProject.dto.post;

import com.example.BlogProject.dto.response;
import com.example.BlogProject.model.Post;

import java.time.LocalDateTime;

public class PostResponseDTO {
    private Long id;
    private String title;
    private String content;
    private String user;
    private String category;
    private LocalDateTime createdAt;

    public PostResponseDTO(Long id,
                           String title,
                           String content,
                           String user,
                           String category,
                           LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
        this.category = category;
        this.createdAt = createdAt;
    }

    //setters and getters

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
