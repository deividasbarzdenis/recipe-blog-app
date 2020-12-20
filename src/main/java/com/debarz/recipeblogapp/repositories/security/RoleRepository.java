package com.debarz.recipeblogapp.repositories.security;

import com.debarz.recipeblogapp.domain.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(@Param("role") String role);

}
