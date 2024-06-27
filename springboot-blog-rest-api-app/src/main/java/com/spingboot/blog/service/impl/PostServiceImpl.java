package com.spingboot.blog.service.impl;

import org.springframework.stereotype.Service;

import com.spingboot.blog.entity.Post;
import com.spingboot.blog.payload.PostDto;
import com.spingboot.blog.repository.PostRepository;
import com.spingboot.blog.service.PostService;

@Service
public class PostServiceImpl implements PostService{

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
       
        //convert DTO to entity
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        
        
        Post newPost = postRepository.save(post);

        //convert entity to DTO
        PostDto postResponse = new PostDto();
        postResponse.setId(newPost.getId());
        postResponse.setTitle(newPost.getTitle());
        postResponse.setDescription(newPost.getDescription());
        postResponse.setContent(newPost.getContent());

        return postResponse;
    }
    
}
