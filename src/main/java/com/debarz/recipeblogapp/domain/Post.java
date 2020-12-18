package com.debarz.recipeblogapp.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Post extends BaseEntity{

    private String title;

    @Lob
    private String content;

    @Column(nullable = false)
    private LocalDate creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Person author;

    @OneToMany(mappedBy="post")
    private Set<Comment> comments = new HashSet<>();

    @Builder // lombok anotacija, sukonstroukti objekta su builder() ir build() metodais
    public Post(Long id, String title, String content, LocalDate creationDate, Person author, Set<Comment> comments) {
        super(id);
        this.title = title;
        this.content = content;
        this.creationDate = LocalDate.now();
        this.author = author;
        this.comments = comments;
    }
}
