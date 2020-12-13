package com.debarz.recipeblogapp.domain.security;

import com.debarz.recipeblogapp.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User extends Person{

    private String loginName;

    private String password;

    //private Set<Role> roles;

    //private Set<Authority> authorities;



}
