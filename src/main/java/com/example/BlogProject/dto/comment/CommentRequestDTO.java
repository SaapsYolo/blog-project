package com.example.BlogProject.dto.comment;

public class CommentRequestDTO {
    private String content;
    private Long userId;
    private Long postId;

    public CommentRequestDTO() {
    }

    //getters and setters

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

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
