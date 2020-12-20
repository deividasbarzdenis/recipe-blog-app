package com.debarz.recipeblogapp.services.datajpa;

import com.debarz.recipeblogapp.domain.Comment;
import com.debarz.recipeblogapp.repositories.CommentRepository;
import com.debarz.recipeblogapp.services.CommentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@AllArgsConstructor
@Service
public class CommentJpaService implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public Comment save(Comment comment) {
        return commentRepository.saveAndFlush(comment);
    }
}
