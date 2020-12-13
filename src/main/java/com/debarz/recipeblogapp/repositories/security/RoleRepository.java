package com.debarz.recipeblogapp.repositories.security;

import com.debarz.recipeblogapp.domain.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
