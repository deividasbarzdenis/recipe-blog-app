package com.debarz.recipeblogapp.services.datajpa;

import com.debarz.recipeblogapp.domain.Post;
import com.debarz.recipeblogapp.domain.security.User;
import com.debarz.recipeblogapp.repositories.PostRepository;
import com.debarz.recipeblogapp.services.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class PostJpaService implements PostService {

    private final PostRepository postRepository;

    @Override//+
    public Optional<Post> findForId(Long id) {
        return postRepository.findById(id);
    }

    @Override//+
    public Post save(Post post) {
        return postRepository.saveAndFlush(post);
    }

    @Override//+
    public Page<Post> findByUserOrderedByDatePageable(User user, int page) {
        return postRepository.findByUserOrderByCreateDateDesc(user, PageRequest.of(subtractPageByOne(page), 5));
    }

    @Override//+
    public Page<Post> findAllOrderedByDatePageable(int page) {
        return postRepository.findAllByOrderByCreateDateDesc(PageRequest.of(subtractPageByOne(page), 5));
    }

    @Override//+
    public void delete(Post post) {
        postRepository.delete(post);
    }

    private int subtractPageByOne(int page){
        return (page < 1) ? 0 : page - 1;
    }

}
