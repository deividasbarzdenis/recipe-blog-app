package com.debarz.recipeblogapp.domain;

import com.debarz.recipeblogapp.domain.security.User;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
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

    @OneToMany(mappedBy = "person")
    private Set<User> users = new HashSet<>();

    @Lob
    private Byte[] avatarImage;

    @Builder

    public Person(Long id, String name, String lastName,
                  String email, Set<User> users,
                  Byte[] avatarImage) {
        super(id);
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.users = users;
        this.avatarImage = avatarImage;
    }

}
