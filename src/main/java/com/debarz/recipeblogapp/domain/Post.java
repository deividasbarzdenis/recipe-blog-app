package com.debarz.recipeblogapp.domain;

import java.time.LocalDate;
import java.util.Set;

public class Post extends BaseEntity{


    private String title;

    private String content;

    private Person author;

    private LocalDate creationDate;

    private Set<Comment> comments;
}
