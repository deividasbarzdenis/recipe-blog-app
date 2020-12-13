package com.debarz.recipeblogapp.repositories.security;

import com.debarz.recipeblogapp.domain.security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
