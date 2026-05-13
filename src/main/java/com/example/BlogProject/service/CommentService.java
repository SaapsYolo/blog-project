package com.example.BlogProject.service;

import com.example.BlogProject.dto.comment.CommentRequestDTO;
import com.example.BlogProject.dto.comment.CommentResponseDTO;

import java.util.List;

public interface CommentService {
    CommentResponseDTO createComment(CommentRequestDTO requestDTO);
    List<CommentResponseDTO> getAllComments();
    CommentResponseDTO getCommentById(Long id);
    CommentResponseDTO updateComment(Long id, CommentRequestDTO requestDTO);
    void deleteComment(Long id);

}
