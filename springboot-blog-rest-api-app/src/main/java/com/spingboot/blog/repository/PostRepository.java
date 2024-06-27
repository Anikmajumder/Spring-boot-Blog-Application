package com.spingboot.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spingboot.blog.entity.Post;

public interface PostRepository  extends JpaRepository<Post, Long>{
    
}
