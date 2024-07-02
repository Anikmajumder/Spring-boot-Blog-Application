package com.spingboot.blog.service;

import java.util.List;

import com.spingboot.blog.payload.CommentDto;

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);
    
    List<CommentDto> getCommentsByPostId(long postId);
}
