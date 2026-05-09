package com.example.BlogProject.service;

import com.example.BlogProject.dto.post.PostRequestDTO;
import com.example.BlogProject.dto.post.PostResponseDTO;
import com.example.BlogProject.exception.ResourceNotFoundException;
import com.example.BlogProject.model.Post;
import com.example.BlogProject.model.User;
import com.example.BlogProject.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }


    //mapper method
    public PostResponseDTO mapToDTO(Post post){
        // safely handle nulls
        String username = post.getUser() != null
                ? post.getUser().getUsername()
                : null;

        String categoryName = post.getCategory() != null
                ? post.getCategory().getName()
                : null;



        return new PostResponseDTO(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                username,
                categoryName,
                post.getCreatedAt()
        );
    }

    @Override
    public PostResponseDTO createPost(PostRequestDTO requestDTO){
        Post post = new Post();

        post.setTitle(requestDTO.getTitle());
        post.setContent(requestDTO.getContent());

        Post savedPost = postRepository.save(post);

        return mapToDTO(savedPost);
    }

    @Override
    public List<PostResponseDTO> getAllPosts(){
        List<Post> posts = postRepository.findAll();

        return posts.stream().map(this::mapToDTO).toList();
    }

    @Override
    public PostResponseDTO getPostById(Long id){

        Post post = postRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Post not found with id: " +id)
        );

        return mapToDTO(post);
    }

    @Override
    public PostResponseDTO updatePost(Long id, PostRequestDTO requestDTO){

        Post post = postRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Post not found with id: " + id)
        );

        post.setTitle(requestDTO.getTitle());
        post.setContent(requestDTO.getContent());

        Post updatedPost = postRepository.save(post);

        return mapToDTO(updatedPost);
    }

    @Override
    public void deletePost(Long id){
        postRepository.deleteById(id);
    }
}
