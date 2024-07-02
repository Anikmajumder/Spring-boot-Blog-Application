package com.spingboot.blog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spingboot.blog.entity.Comment;
import com.spingboot.blog.entity.Post;
import com.spingboot.blog.exception.ResourceNotFoundException;
import com.spingboot.blog.payload.CommentDto;
import com.spingboot.blog.repository.CommentRepository;
import com.spingboot.blog.repository.PostRepository;
import com.spingboot.blog.service.CommentService;

@Service
public class  CommentServiceImpl implements CommentService{

     
    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository){
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
       
        Comment comment = mapToEntity(commentDto);

        //retrive post entity by id
        Post post = postRepository.findById(postId).orElseThrow(
            ()-> new ResourceNotFoundException("Post", "id", postId)
        );
        
        //set post to comment entity
        comment.setPost(post);

        //comment entity to DB
        Comment newComment = commentRepository.save(comment);
        CommentDto  commentResponse = mapToDTO(newComment);

        return commentResponse;

        
    }

    @Override
    public List<CommentDto> getCommentsByPostId(long postId) {
        
        //retrive comments by post id
        List<Comment> comments = commentRepository.findByPostId(postId);

        //convert list of comment entities to List of comment dto's
        return comments.stream().map(comment -> mapToDTO(comment)).collect(Collectors.toList());        
    }

    private CommentDto mapToDTO(Comment comment){
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setName(comment.getName());
        commentDto.setEmail(comment.getEmail());
        commentDto.setBody(comment.getBody());
        return commentDto;
    }

    private Comment mapToEntity(CommentDto commentDto){
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());
        return comment;
    }

    

    


}
