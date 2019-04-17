package com.github.springbootfpm.repository;

import com.github.springbootfpm.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
