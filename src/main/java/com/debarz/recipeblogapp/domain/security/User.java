package com.debarz.recipeblogapp.domain.security;

import com.debarz.recipeblogapp.domain.Person;

import java.util.Set;

public class User extends Person{

    private String loginName;

    private String password;

    private Set<Role> roles;

    private Set<Authority> authorities;



}
