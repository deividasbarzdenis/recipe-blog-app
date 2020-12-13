package com.debarz.recipeblogapp.domain;

import java.util.Set;

public class Person extends BaseEntity{

    private String name;

    private String lastName;

    private String emailName;

    private Set<Post> posts;

    private Byte[] avatarImage;

}
