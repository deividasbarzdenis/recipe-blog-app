package com.debarz.recipeblogapp.services.datajpa;

import com.debarz.recipeblogapp.domain.Comment;
import com.debarz.recipeblogapp.repositories.CommentRepository;
import com.debarz.recipeblogapp.repositories.PostRepository;
import com.debarz.recipeblogapp.services.CommentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class CommentJpaService implements CommentService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;


    @Override
    public Comment findByPostIdAndCommentId(Long postId, Long commentId) {
        return null;
    }

    @Override
    public Comment saveComment(Comment comment) {
        return null;
    }

    @Override
    public void deleteById(Long postId, Long commentId) {

    }
}
