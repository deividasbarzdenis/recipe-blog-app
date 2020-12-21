package com.debarz.recipeblogapp.domain.security;

import com.debarz.recipeblogapp.domain.BaseEntity;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role extends BaseEntity implements GrantedAuthority {

    @Column(name = "role_name")
    private String roleName;

    @Builder
    public Role(Long id, String role) {
        super(id);
        this.roleName = role;
    }

    @Override
    public String getAuthority() {
        return "ROLE_"+ roleName;
    }
}
