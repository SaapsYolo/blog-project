package com.example.BlogProject.implementation;

import com.example.BlogProject.exception.ResourceNotFoundException;
import com.example.BlogProject.model.Post;
import com.example.BlogProject.repository.PostRepository;
import com.example.BlogProject.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public Post createPost(Post post){
        return postRepository.save(post);
    }

    @Override
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long id){
        return postRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Post not found with id: " + id)
        );

    }

    @Override
    public Post updatePost(Long id, Post updatePost){
        Post post = getPostById(id);

        post.setTitle(updatePost.getTitle());
        post.setContent(updatePost.getContent());
        post.setUser(updatePost.getUser());

        return postRepository.save(post);
    }

    @Override
    public void deletePost(Long id){
        postRepository.deleteById(id);
    }
}
