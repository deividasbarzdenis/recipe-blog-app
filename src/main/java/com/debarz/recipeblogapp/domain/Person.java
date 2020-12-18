package com.debarz.recipeblogapp.domain;

import com.debarz.recipeblogapp.domain.security.User;
import lombok.*;

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

    @Builder

    public Person(Long id, String name, String lastName,
                  String email, Set<Post> posts, Set<User> users,
                  Set<Comment> comments, Byte[] avatarImage) {
        super(id);
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.posts = posts;
        this.users = users;
        this.comments = comments;
        this.avatarImage = avatarImage;
    }

}
