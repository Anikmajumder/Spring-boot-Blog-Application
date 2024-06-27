package com.spingboot.blog.service;

import com.spingboot.blog.payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);
    
} 