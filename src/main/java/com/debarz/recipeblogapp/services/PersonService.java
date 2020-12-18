package com.debarz.recipeblogapp.services;

import com.debarz.recipeblogapp.domain.Person;

import java.util.Set;

public interface PersonService {

    Set<Person> getAllPersons();

    Person save(Person person);

    Person findById(Long l);

    void deleteById(Long idToDelete);

}
