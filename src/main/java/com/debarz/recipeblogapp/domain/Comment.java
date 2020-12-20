package com.debarz.recipeblogapp.domain;

import com.debarz.recipeblogapp.domain.security.User;
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

    @Lob
    @Column(name = "body", columnDefinition = "TEXT")
    @NotEmpty(message = "*Please write something")
    private String body;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false, updatable = false)
    @CreationTimestamp
    private Date createDate;

    @ManyToOne
    @NotNull
    private Post post;

    @ManyToOne
    @NotNull
    private User user;

    @Builder
    public Comment(Long id, String body,
                   Date createDate, @NotNull Post post, @NotNull User user) {
        super(id);
        this.body = body;
        this.createDate = createDate;
        this.post = post;
        this.user = user;
    }
}
