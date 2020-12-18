package com.debarz.recipeblogapp.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private LocalDateTime creationDate = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    private Person author;

    @OneToMany(mappedBy="post")
    private Set<Comment> comments = new HashSet<>();

    @Builder // lombok anotacija, sukonstroukti objekta su builder() ir build() metodais
    public Post(Long id, String title, String content, LocalDateTime creationDate, Person author, Set<Comment> comments) {
        super(id);
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.author = author;
        this.comments = comments;
    }
}
