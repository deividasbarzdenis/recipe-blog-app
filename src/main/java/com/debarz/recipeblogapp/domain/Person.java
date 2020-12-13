package com.debarz.recipeblogapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity{

    private String name;

    private String lastName;

    private String emailName;

    private Set<Post> posts;

    private Byte[] avatarImage;

}
