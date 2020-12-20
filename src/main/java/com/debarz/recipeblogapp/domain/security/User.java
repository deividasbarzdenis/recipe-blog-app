package com.debarz.recipeblogapp.domain.security;

import com.debarz.recipeblogapp.domain.BaseEntity;
import com.debarz.recipeblogapp.domain.Comment;
import com.debarz.recipeblogapp.domain.Person;
import com.debarz.recipeblogapp.domain.Post;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User extends BaseEntity {

    @NotEmpty(message = "*Please provide your name")
    private String loginName;

    // TODO: add message from property file
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    private String password;

    @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")})
    private Set<Role> roles;

    @ManyToOne(fetch = FetchType.EAGER)
    private Person person;

    @OneToMany(mappedBy = "author")
    private Set<Post> posts = new HashSet<>();

    @OneToMany(mappedBy = "author")
    private Set<Comment> comments = new HashSet<>();

    @Builder.Default
    private Boolean accountNonExpired = true;

    @Builder.Default
    private Boolean accountNonLocked = true;

    @Builder.Default
    private Boolean credentialNonExpired = true;

    @Builder.Default
    private Boolean enabled = true;



}
