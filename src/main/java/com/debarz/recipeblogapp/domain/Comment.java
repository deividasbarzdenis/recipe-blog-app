package com.debarz.recipeblogapp.domain;

import java.time.LocalDateTime;

public class Comment extends BaseEntity{

    private String commentTitle;

    private String commentContent;

    private Person author;

    private LocalDateTime creationTime;

    private Post post;

}
