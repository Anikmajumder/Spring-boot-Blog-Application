package com.spingboot.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spingboot.blog.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
    
}
