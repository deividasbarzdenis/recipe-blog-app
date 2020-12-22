package com.debarz.recipeblogapp.services.datajpa;

import com.debarz.recipeblogapp.domain.Post;
import com.debarz.recipeblogapp.repositories.PostRepository;
import com.debarz.recipeblogapp.services.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class PostJpaService implements PostService {

    private final PostRepository postRepository;

    @Override
    public Page<Post> getAllPost(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Post findById(Long aLong){
        return postRepository.findById(aLong).orElse(null);
    }

    @Override
    public Post save(Post object) {
        return postRepository.save(object);
    }

    @Override
    public void delete(Post object) {
        postRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        postRepository.deleteById(aLong);
    }

/*    @Override
    public Page<Post> findByUserOrderedByDatePageable(User user, int page) {
        return postRepository.findByUserOrderByCreateDateDesc(user, PageRequest.of(subtractPageByOne(page), 6));
    }

    @Override
    public Page<Post> findAllOrderedByDatePageable(int page) {
        return postRepository.findAllByOrderByCreateDateDesc(PageRequest.of(subtractPageByOne(page), 6));
    }

    private int subtractPageByOne(int page){
        return (page < 1) ? 0 : page - 1;
    }*/

}
