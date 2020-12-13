package com.debarz.recipeblogapp.domain.security;

import com.debarz.recipeblogapp.domain.BaseEntity;

import java.util.Set;

public class Role extends BaseEntity {

    private String name;

    private Set<User> users;

    private Set<Authority> authorities;
}
