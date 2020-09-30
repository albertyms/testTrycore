package com.trycore.test.controller;

import com.trycore.test.entity.Person;
import com.trycore.test.entity.Planet;
import com.trycore.test.entity.PlanetPersonReg;
import com.trycore.test.request.PlanetPersonRegRequest;
import com.trycore.test.service.PersonService;
import com.trycore.test.service.PlanetPersonRegService;
import com.trycore.test.service.PlanetService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/planetPersonReg")
public class PlanetPersonRegController {
    private Logger logger = LogManager.getLogger(PersonController.class);

    @Autowired
    PlanetPersonRegService planetPersonRegService;

    @Autowired
    PlanetService planetService;

    @Autowired
    PersonService personService;

    @PostMapping
    public ResponseEntity create(@Validated @RequestBody PlanetPersonRegRequest request) {
        try {
            PlanetPersonReg planetPersonReg = new PlanetPersonReg();
            Optional<Person> person = personService.findById(request.getPersonId());
            Optional<Planet> planet = planetService.findById(request.getPlanetId());
            Optional<PlanetPersonReg> planetPersonRegVal = planetPersonRegService.findPerson(person.get());
            if (person.isPresent()) {
                if (!planetPersonRegVal.isPresent()) {
                    planetPersonReg.setPerson(person.get());
                } else {
                    return new ResponseEntity<>("Person alredy asosiated with planet name:" + planetPersonRegVal.get().getPlanet().getName(), HttpStatus.CONFLICT);
                }
            } else {
                return new ResponseEntity<>("Person Not Found", HttpStatus.NOT_FOUND);
            }
            if (planet.isPresent()) {
                planetPersonReg.setPlanet(planet.get());
            } else {
                return new ResponseEntity<>("Planet Not Found", HttpStatus.NOT_FOUND);
            }
            planetPersonReg = planetPersonRegService.create(planetPersonReg);
            return ResponseEntity.ok(planetPersonReg);
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @Validated @RequestBody PlanetPersonRegRequest request) {
        try {
            Optional<Person> person = personService.findById(request.getPersonId());
            Optional<Planet> planet = planetService.findById(request.getPlanetId());
            PlanetPersonReg planetPersonReg = new PlanetPersonReg();
            if (person.isPresent()) {
                planetPersonReg.setPerson(person.get());
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person Not Found");
            }
            if (planet.isPresent()) {
                planetPersonReg.setPlanet(planet.get());
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Planet Not Found");
            }
            planetPersonReg = planetPersonRegService.update(id, planetPersonReg);

            return ResponseEntity.ok(planetPersonReg);
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    @GetMapping("/findByPersonId/{idPerson}")
    public ResponseEntity findByIds(@PathVariable Long idPerson) {
        try {
            Optional<Person> person = personService.findById(idPerson);
            if (person.isPresent()) {
                Optional<PlanetPersonReg> planetPersonReg = planetPersonRegService.findPerson(person.get());
                if (planetPersonReg.isPresent()) {
                    return ResponseEntity.ok(planetPersonReg.get());
                } else {
                    return new ResponseEntity<>("Person Not Found", HttpStatus.NOT_FOUND);
                }
            } else {
                return new ResponseEntity<>("Person Not Found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<PlanetPersonReg>> findAll() {
        return ResponseEntity.ok(planetPersonRegService.findAll());
    }
}
