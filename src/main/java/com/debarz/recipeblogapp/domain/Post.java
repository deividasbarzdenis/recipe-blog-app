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
import java.util.Collection;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table
public class Post extends BaseEntity{


    @Column(name = "title", nullable = false)
    @Length(min = 5, message = "*Your title must have at least 5 characters")
    @NotEmpty(message = "*Please provide title")
    private String title;

    @Lob
    @Column(name = "body", columnDefinition = "TEXT")
    private String body;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false, updatable = false)
    @CreationTimestamp
    private Date createDate;

    @ManyToOne
    @NotNull
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private Collection<Comment> comments;

    @Builder // lombok anotacija, sukonstroukti objekta su builder() ir build() metodais

    public Post(Long id,
                @Length(min = 5, message = "*Your title must have at least 5 characters") @NotEmpty(message = "*Please provide title") String title,
                String body, Date createDate, @NotNull User user, Collection<Comment> comments) {
        super(id);
        this.title = title;
        this.body = body;
        this.createDate = createDate;
        this.user = user;
        this.comments = comments;
    }
}
