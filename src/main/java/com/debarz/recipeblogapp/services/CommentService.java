package com.debarz.recipeblogapp.services;

import com.debarz.recipeblogapp.domain.Comment;

public interface CommentService {

    Comment findByPostIdAndCommentId(Long postId, Long commentId);

    Comment saveComment(Comment comment);

    void deleteById(Long postId, Long commentId);
}
