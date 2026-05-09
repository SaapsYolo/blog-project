package com.example.BlogProject.service;

import com.example.BlogProject.model.Post;

import java.util.List;

public interface PostService {
    Post createPost(Post post);
    List<Post> getAllPosts();
    Post getPostById(Long id);
    Post updatePost(Long id, Post post);
    void deletePost(Long id);
}
