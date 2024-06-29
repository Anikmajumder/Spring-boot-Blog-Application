package com.spingboot.blog.service;

import java.util.List;

import com.spingboot.blog.payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPost(int pageNo, int pageSize);

    PostDto getPostById(Long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);
    


    
} 