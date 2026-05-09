package com.example.BlogProject.controller;

import com.example.BlogProject.dto.post.PostRequestDTO;
import com.example.BlogProject.dto.post.PostResponseDTO;
import com.example.BlogProject.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @PostMapping
    public PostResponseDTO createPost(@RequestBody PostRequestDTO requestDTO){
        return postService.createPost(requestDTO);
    }

    @GetMapping
    public List<PostResponseDTO> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public PostResponseDTO getPostById(@PathVariable Long id){
        return postService.getPostById(id);
    }

    @PutMapping("/{id}")
    public PostResponseDTO updatePost(@PathVariable Long id, @RequestBody PostRequestDTO requestDTO){
        return postService.updatePost(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }
}
