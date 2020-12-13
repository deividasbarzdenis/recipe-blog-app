package com.debarz.recipeblogapp.services.datajpa;

import com.debarz.recipeblogapp.domain.Comment;
import com.debarz.recipeblogapp.domain.Post;
import com.debarz.recipeblogapp.repositories.CommentRepository;
import com.debarz.recipeblogapp.repositories.PostRepository;
import com.debarz.recipeblogapp.repositories.security.UserRepository;
import com.debarz.recipeblogapp.services.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@AllArgsConstructor
@Service
public class PostJpaService implements PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    @Override
    public Page<Post> getAllPost(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Set<Comment> getAllComments() {
        Set<Comment> comments = new HashSet<>();
        commentRepository.findAll().forEach(comments::add);
        return comments;
    }
}
