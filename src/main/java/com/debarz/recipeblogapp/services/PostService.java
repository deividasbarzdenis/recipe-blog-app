package com.debarz.recipeblogapp.services;

import com.debarz.recipeblogapp.domain.Comment;
import com.debarz.recipeblogapp.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface PostService {

    Page<Post> getAllPost(Pageable pageable);

    Set<Comment> getAllComments();

    Post findById(Long aLong);

    Post save(Post object);

    void delete(Post object);

    void deleteById(Long aLong);
}
