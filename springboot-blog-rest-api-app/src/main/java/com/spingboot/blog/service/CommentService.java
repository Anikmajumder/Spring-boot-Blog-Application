package com.spingboot.blog.service;

import com.spingboot.blog.payload.CommentDto;

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);    
}
