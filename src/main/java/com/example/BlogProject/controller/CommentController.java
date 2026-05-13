package com.example.BlogProject.controller;

import com.example.BlogProject.dto.comment.CommentRequestDTO;
import com.example.BlogProject.dto.comment.CommentResponseDTO;
import com.example.BlogProject.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public CommentResponseDTO createComment(@RequestBody CommentRequestDTO requestDTO){
        return commentService.createComment(requestDTO);
    }

    @GetMapping
    public List<CommentResponseDTO> getAllComments(){
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public CommentResponseDTO getCommentById(@PathVariable Long id){
        return commentService.getCommentById(id);
    }

    @PutMapping("/{id}")
    public CommentResponseDTO updateComment(@PathVariable Long id, @RequestBody CommentRequestDTO requestDTO){
        return commentService.updateComment(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id){
        commentService.deleteComment(id);
    }
}
