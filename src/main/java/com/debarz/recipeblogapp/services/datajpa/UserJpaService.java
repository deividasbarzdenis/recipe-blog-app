package com.debarz.recipeblogapp.services.datajpa;

import com.debarz.recipeblogapp.domain.Person;
import com.debarz.recipeblogapp.domain.security.User;
import com.debarz.recipeblogapp.repositories.security.UserRepository;
import com.debarz.recipeblogapp.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@AllArgsConstructor
@Service
public class UserJpaService implements UserService {

    private final UserRepository userRepository;

    @Override
    public Set<User> getAllUsers() {
        Set<User> userSet = new HashSet<>();
        userRepository.findAll().forEach(userSet::add);
        return userSet;
    }

    @Override
    public User save(Person person) {
        return null;
    }

    @Override
    public Object findById(Long valueOf) {
        return null;
    }
}
