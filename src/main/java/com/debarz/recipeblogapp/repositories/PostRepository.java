package com.debarz.recipeblogapp.repositories;

import com.debarz.recipeblogapp.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findAllByName(String postName, Pageable pageable);
}
