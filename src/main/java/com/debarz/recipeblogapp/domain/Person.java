package com.debarz.recipeblogapp.domain;

import com.debarz.recipeblogapp.domain.security.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person extends BaseEntity{

    private String name;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    @OneToMany(mappedBy = "author")
    private Set<Post> posts = new HashSet<>();

    @OneToMany(mappedBy = "person")
    private Set<User> users = new HashSet<>();

    @OneToMany(mappedBy = "author")
    private Set<Comment> comments = new HashSet<>();

    private Byte[] avatarImage;

}
