package com.debarz.recipeblogapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends BaseEntity{

    private String commentTitle;

    private String commentContent;

    private Person author;

    private LocalDateTime creationTime;

    private Post post;

}
