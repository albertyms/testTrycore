package com.trycore.test.controller;

import com.trycore.test.entity.Person;
import com.trycore.test.request.PersonRequest;
import com.trycore.test.service.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/person")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class PersonController {
    private Logger logger = LogManager.getLogger(PersonController.class);

    @Autowired
    PersonService personService;

    @PostMapping
    public ResponseEntity create(@Validated @RequestBody PersonRequest request) {
        try {
            Person person = new Person(request);
            return ResponseEntity.ok(personService.create(person));
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @Validated @RequestBody PersonRequest request) {
        try {
            if (personService.findById(id).isPresent()) {
                return ResponseEntity.ok(personService.update(id, request));
            } else {
                return new ResponseEntity<>("Person Not Found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(personService.findById(id).get());
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Person>> findAll() {
        return ResponseEntity.ok(personService.findAll());
    }

    @PutMapping("/updateView/{id}")
    public ResponseEntity updateCountView(@PathVariable Long id) {
        try {
            if (personService.findById(id).isPresent()) {
                return ResponseEntity.ok(personService.updateViewCount(id, personService.findById(id).get()));
            } else {
                return new ResponseEntity<>("Person Not Found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

}
