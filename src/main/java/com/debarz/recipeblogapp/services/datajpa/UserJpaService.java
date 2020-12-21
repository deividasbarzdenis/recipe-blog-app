package com.debarz.recipeblogapp.services.datajpa;

import com.debarz.recipeblogapp.domain.User;
import com.debarz.recipeblogapp.domain.security.Role;
import com.debarz.recipeblogapp.repositories.UserRepository;
import com.debarz.recipeblogapp.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class UserJpaService implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserJpaService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public static final String USER_ROLE = "USER";

    @Override
    public Set<User> getAllUsers() {
        log.debug("Person Service!!!!");
        Set<User> persons = new HashSet<>();
        userRepository.findAll().forEach(persons::add);
        return persons;
    }


    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(Arrays.asList(Role.builder()
                .role(USER_ROLE)
                .build())));
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long idToDelete) {
        userRepository.deleteById(idToDelete);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findByLastName(String username) {
        return userRepository.findByLastName(username);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    @Override
    public User loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException(s));
    }
}
