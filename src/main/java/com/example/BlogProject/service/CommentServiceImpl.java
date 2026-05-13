package com.example.BlogProject.service;

import com.example.BlogProject.dto.comment.CommentRequestDTO;
import com.example.BlogProject.dto.comment.CommentResponseDTO;
import com.example.BlogProject.exception.ResourceNotFoundException;
import com.example.BlogProject.model.Comment;
import com.example.BlogProject.model.Post;
import com.example.BlogProject.model.User;
import com.example.BlogProject.repository.CommentRepository;
import com.example.BlogProject.repository.PostRepository;
import com.example.BlogProject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, UserRepository userRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    //mapper
    private CommentResponseDTO mapToDTO(Comment comment){
        return new CommentResponseDTO(
                comment.getId(),
                comment.getContent(),
                comment.getUser().getUsername(),
                comment.getPost().getId(),
                comment.getCreatedAt()
        );
    }

    @Override
    public CommentResponseDTO createComment(CommentRequestDTO requestDTO){
        User user = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(()->
                        new ResourceNotFoundException("User not found")
                );

        Post post = postRepository.findById(requestDTO.getPostId())
                .orElseThrow(()->
                        new ResourceNotFoundException("Post not found")
                );
        Comment comment = new Comment();

        comment.setContent(requestDTO.getContent());
        comment.setUser(user);
        comment.setPost(post);

        Comment savedComment = commentRepository.save(comment);

        return mapToDTO(savedComment);
    }

    @Override
    public List<CommentResponseDTO> getAllComments(){
        List<Comment> comments = commentRepository.findAll();

        return comments.stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public CommentResponseDTO getCommentById(Long id){
        Comment comment = commentRepository.findById(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("Comment not found with id: " +id)
                );

        return mapToDTO(comment);
    }

    @Override
    public CommentResponseDTO updateComment(Long id, CommentRequestDTO requestDTO){
        Comment comment = commentRepository.findById(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("Comment not found with id: "+ id)
                );

        comment.setContent(requestDTO.getContent());

        Comment updatedComment = commentRepository.save(comment);

        return mapToDTO(updatedComment);
    }

    @Override
    public void deleteComment(Long id){
        commentRepository.deleteById(id);
    }
}
