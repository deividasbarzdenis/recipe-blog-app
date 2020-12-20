package com.debarz.recipeblogapp.domain.security;

import com.debarz.recipeblogapp.domain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Collection;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Role extends BaseEntity {

    private String name;

    @Column(name = "role", unique = true)
    private String role;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles")
    private Collection<User> users;
}
