package com.example.BlogProject.service;

import com.example.BlogProject.dto.post.PostRequestDTO;
import com.example.BlogProject.dto.post.PostResponseDTO;
import com.example.BlogProject.model.Post;

import java.util.List;

public interface PostService {
    PostResponseDTO createPost(PostRequestDTO requestDTO);
    List<PostResponseDTO> getAllPosts();
    PostResponseDTO getPostById(Long id);
    PostResponseDTO updatePost(Long id, PostRequestDTO requestDTO);
    void deletePost(Long id);
}
