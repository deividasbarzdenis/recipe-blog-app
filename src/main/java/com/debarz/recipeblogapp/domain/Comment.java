package com.debarz.recipeblogapp.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment extends BaseEntity{


    private String commentTitle;

    // TODO: prideti validation messages.properties
    @Lob
    @NotEmpty(message = "*Please write something")
    private String body;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.PERSIST, CascadeType.REFRESH})
    private User author;

    @Temporal(TemporalType.TIMESTAMP)// insert  both time and date.
    @Column(name = "creation_time", nullable = false, updatable = false)
    @CreationTimestamp
    private Date creationTime = new Date();

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @NotNull
    private Post post;

    @Builder
    public Comment(Long id, String commentTitle, @NotEmpty(message = "*Please write something") String body, User author, Date creationTime, @NotNull Post post) {
        super(id);
        this.commentTitle = commentTitle;
        this.body = body;
        this.author = author;
        this.creationTime = creationTime;
        this.post = post;
    }
}
