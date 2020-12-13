package com.debarz.recipeblogapp.services;

import com.debarz.recipeblogapp.domain.Comment;
import com.debarz.recipeblogapp.domain.Post;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface PostService {

    Set<Post> getAllPost(Pageable pageable);

    Set<Comment> getAllComments();

}
