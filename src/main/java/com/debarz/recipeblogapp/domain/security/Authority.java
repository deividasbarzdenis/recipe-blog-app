package com.debarz.recipeblogapp.domain.security;

import com.debarz.recipeblogapp.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Authority extends BaseEntity {

    private String permission;

    @ManyToMany(mappedBy = "authorities")
    private Set<Role> roles;
}
