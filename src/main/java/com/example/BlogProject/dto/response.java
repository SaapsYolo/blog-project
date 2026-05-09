package com.example.BlogProject.dto;

import com.example.BlogProject.model.Post;

import java.time.LocalDateTime;

public class response {
    private Long id;
    private String title;
    private String content;
    private String user;
    private String category;
    private LocalDateTime createdAt;

    public response mapToDTO(Post post) {
        return new response(
        post.getId();
        post.getTitle();
        post.getContent();
        post.getUser().getUsername();
        post.getCategory().getName();
        post.getCreatedAt();
        );
    }

    //setters & getters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
