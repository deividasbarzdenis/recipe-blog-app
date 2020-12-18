package com.debarz.recipeblogapp.services;

import com.debarz.recipeblogapp.domain.security.User;

import java.util.Set;

public interface UserService{

    Set<User> getAllUsers();

    User save(User person);

    Object findById(Long valueOf);
}
