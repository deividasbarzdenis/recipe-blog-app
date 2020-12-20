package com.debarz.recipeblogapp.services.datajpa;

import com.debarz.recipeblogapp.domain.security.User;
import com.debarz.recipeblogapp.repositories.security.RoleRepository;
import com.debarz.recipeblogapp.repositories.security.UserRepository;
import com.debarz.recipeblogapp.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Slf4j
@Service
public class UserJpaService implements UserService {

    private static final String USER_ROLE = "ROLE_USER";

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserJpaService(UserRepository userRepository, RoleRepository roleRepository,
                          PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(User user) {
        // Encode plaintext password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(1);
        // Set Role to ROLE_USER
        user.setRoles(Collections.singletonList(roleRepository.findByRole(USER_ROLE)));
        return userRepository.saveAndFlush(user);
    }
}
