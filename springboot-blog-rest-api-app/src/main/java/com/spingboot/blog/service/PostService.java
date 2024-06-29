package com.spingboot.blog.service;

import java.util.List;

import com.spingboot.blog.payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPost();

    PostDto getPostById(Long id);


    
} 