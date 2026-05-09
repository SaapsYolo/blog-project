package com.example.BlogProject.dto.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@NotBlank
@Size(min = 3)
public class PostRequestDTO {
    private String title;
    private String content;
    private Long userId;
    private Long categoryId;

    //setters & getters
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
