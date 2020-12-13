package com.debarz.recipeblogapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Post extends BaseEntity{


    private String title;

    private String content;

    private Person author;

    private LocalDate creationDate;

    private Set<Comment> comments;
}
