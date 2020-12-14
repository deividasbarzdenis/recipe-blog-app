package com.debarz.recipeblogapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Post extends BaseEntity{

    private String title;

    @Lob
    private String content;

    @Column(nullable = false)
    private LocalDate creationDate = LocalDate.now();

    @ManyToOne(fetch = FetchType.LAZY)
    private Person author;

    @OneToMany(mappedBy="post")
    private Set<Comment> comments = new HashSet<>();
}
