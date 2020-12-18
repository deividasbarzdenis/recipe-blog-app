package com.debarz.recipeblogapp.repositories;

import com.debarz.recipeblogapp.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
