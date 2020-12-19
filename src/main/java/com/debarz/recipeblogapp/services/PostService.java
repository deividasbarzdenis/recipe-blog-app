package com.debarz.recipeblogapp.services;

import com.debarz.recipeblogapp.domain.Comment;
import com.debarz.recipeblogapp.domain.Post;
import com.debarz.recipeblogapp.domain.security.User;
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

    // New methods to improve search and posts ordering

    Page<Post> findAllOrderedByDatePageable(int page);

    Page<Post> findByUserOrderedByDatePageable(User user, int page);
}
