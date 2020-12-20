package com.debarz.recipeblogapp.services;

import com.debarz.recipeblogapp.domain.security.User;

import java.util.Optional;

public interface UserService{

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    User save(User user);
}
