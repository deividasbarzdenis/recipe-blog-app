package com.debarz.recipeblogapp.domain.security;

import com.debarz.recipeblogapp.domain.BaseEntity;

import java.util.Set;

public class Authority extends BaseEntity {

    private String permission;

    private Set<Role> roles;
}
