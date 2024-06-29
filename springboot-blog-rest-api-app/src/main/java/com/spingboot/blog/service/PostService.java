package com.spingboot.blog.service;

import java.util.List;

import com.spingboot.blog.payload.PostDto;
import com.spingboot.blog.payload.PostResponse;

public interface PostService {
    PostDto createPost(PostDto postDto);

    PostResponse getAllPost(int pageNo, int pageSize);

    PostDto getPostById(Long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);
    


    
} 