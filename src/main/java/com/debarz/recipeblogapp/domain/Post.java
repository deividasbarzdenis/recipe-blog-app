package com.debarz.recipeblogapp.domain;

import com.debarz.recipeblogapp.domain.security.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Post extends BaseEntity{

    // TODO: add messages from property file
    @Column(name = "title", nullable = false)
    @Length(min = 5, message = "*Your title must have at least 5 characters")
    @NotEmpty(message = "*Please provide title")
    private String title;

    @Lob
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime creationDate = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private User author;

    @OneToMany(mappedBy="post",cascade = CascadeType.REMOVE)
    private Set<Comment> comments = new HashSet<>();

    @Builder // lombok anotacija, sukonstroukti objekta su builder() ir build() metodais
    public Post(Long id, String title, String content, LocalDateTime creationDate, User author, Set<Comment> comments) {
        super(id);
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.author = author;
        this.comments = comments;
    }
}
