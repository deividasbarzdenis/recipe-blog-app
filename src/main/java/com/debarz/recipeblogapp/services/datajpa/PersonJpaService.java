package com.debarz.recipeblogapp.services.datajpa;

import com.debarz.recipeblogapp.domain.Person;
import com.debarz.recipeblogapp.repositories.PersonRepository;
import com.debarz.recipeblogapp.services.PersonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@AllArgsConstructor
@Service
public class PersonJpaService implements PersonService {

    private final PersonRepository personRepo;

    @Override
    public Set<Person> getAllPersons() {
        log.debug("Person Service!!!!");
        Set<Person> persons = new HashSet<>();
        personRepo.findAll().forEach(persons::add);
        return persons;
    }

    @Override
    public Person save(Person person) {
        return personRepo.save(person);
    }

    @Override
    public Person findById(Long id) {
        return personRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long idToDelete) {
        personRepo.deleteById(idToDelete);
    }

}
