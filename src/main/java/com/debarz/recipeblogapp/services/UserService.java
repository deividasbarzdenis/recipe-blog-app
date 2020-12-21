package com.debarz.recipeblogapp.services;

import com.debarz.recipeblogapp.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;
import java.util.Set;

public interface UserService extends UserDetailsService{

    Set<User> getAllUsers();

    User save(User person);

    User findById(Long l);

    void deleteById(Long idToDelete);

    Optional<User> findByEmail(String email);

    Optional<User> findByLastName(String username);

    Optional<User> findByUsername(String username);

}
