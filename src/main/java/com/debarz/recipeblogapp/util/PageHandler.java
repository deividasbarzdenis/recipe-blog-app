package com.debarz.recipeblogapp.util;

import com.debarz.recipeblogapp.domain.Post;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;

@AllArgsConstructor
public class PageHandler {

    private final Page<Post> posts;

    public int getPageIndex() {
        return posts.getNumber() + 1;
    }

    public int getPageSize() {
        return posts.getSize();
    }

    public boolean hasNext() {
        return posts.hasNext();
    }

    public boolean hasPrevious() {
        return posts.hasPrevious();
    }

    public int getTotalPages() {
        return posts.getTotalPages();
    }

    public long getTotalElements() {
        return posts.getTotalElements();
    }

    public Page<Post> getPosts() {
        return posts;
    }

    public boolean indexOutOfBounds() {
        return getPageIndex() < 0 || getPageIndex() > getTotalElements();
    }
}
