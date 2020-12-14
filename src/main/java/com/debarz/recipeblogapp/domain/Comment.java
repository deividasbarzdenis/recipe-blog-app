package com.debarz.recipeblogapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment extends BaseEntity{

    private String commentTitle;

    private String commentContent;

    @ManyToOne(cascade = CascadeType.ALL)
    private Person author;

    private LocalDateTime creationTime = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Post post;

}
