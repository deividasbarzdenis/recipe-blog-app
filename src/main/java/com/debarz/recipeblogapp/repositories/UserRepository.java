package com.debarz.recipeblogapp.repositories;

import com.debarz.recipeblogapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(@Param("email") String email);

    Optional<User> findByLastName(@Param("lastName") String username);

    Optional<User> findByUsername(String username);
}
