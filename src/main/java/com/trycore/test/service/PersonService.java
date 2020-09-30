package com.trycore.test.service;

import com.trycore.test.entity.Person;
import com.trycore.test.repository.PersonRepository;
import com.trycore.test.request.PersonRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PersonService {
    private Logger logger = LogManager.getLogger(PersonService.class);

    @Autowired
    PersonRepository repository;

    public Person create(Person person) {
        try {
            return repository.save(person);
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    public Person update(Long id, PersonRequest request) {
        try {
            Person personUpdate =  new Person(request);
            personUpdate.setId(id);
            return repository.save(personUpdate);
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    public Optional<Person> findById(Long id) {
        Optional<Person> person;
        try {
            return repository.findById(id);
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    public Iterable<Person> findAll() {
        Iterable<Person> persons;
        try {
            return repository.findAll();
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    public Person updateViewCount(Long id, Person person) {
        try {
            person.setCountView(person.getCountView()+1);
            return repository.save(person);
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }
}
