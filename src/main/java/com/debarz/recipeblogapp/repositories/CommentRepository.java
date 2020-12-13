package com.debarz.recipeblogapp.repositories;

import com.debarz.recipeblogapp.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
