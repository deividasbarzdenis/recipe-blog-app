package com.debarz.recipeblogapp.repositories.security;

import com.debarz.recipeblogapp.domain.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

/*    Optional<User> findByLastName(String lastName);

    Optional<User> findByLoginName(String lastName);*/
}
