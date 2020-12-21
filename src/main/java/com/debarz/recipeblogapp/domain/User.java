package com.debarz.recipeblogapp.domain;

import com.debarz.recipeblogapp.domain.security.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class User extends BaseEntity implements UserDetails {

    private String username;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    @Length(min = 5, message = "*Your password must have at least 5 characters")
    private String password;

    @ManyToMany(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="user_roles",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") })
    private Set<Role> roles;

    @OneToMany(mappedBy = "author")
    private Set<Post> posts = new HashSet<>();

    @OneToMany(mappedBy = "author")
    private Set<Comment> comments = new HashSet<>();

    @Lob
    private Byte[] avatarImage;

    @Builder
    public User(Long id, String name, String lastName, String email,
                @Length(min = 5, message = "*Your password must have at least 5 characters") String password,
                Set<Role> roles, Set<Post> posts, Set<Comment> comments) {
        super(id);
        this.username = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.posts = posts;
        this.comments = comments;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
