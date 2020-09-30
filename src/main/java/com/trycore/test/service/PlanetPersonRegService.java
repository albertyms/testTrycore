package com.trycore.test.service;

import com.trycore.test.entity.Person;
import com.trycore.test.entity.Planet;
import com.trycore.test.entity.PlanetPersonReg;
import com.trycore.test.repository.PlanetPersonRegRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PlanetPersonRegService {
    private Logger logger = LogManager.getLogger(PlanetPersonRegService.class);

    @Autowired
    PlanetPersonRegRepository repository;

    public PlanetPersonReg create(PlanetPersonReg planetPersonReg) {
        try {
            return repository.save(planetPersonReg);
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    public PlanetPersonReg update(Long id, PlanetPersonReg request) {
        try {
            request.setId(id);
            return repository.save(request);
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    public Optional<PlanetPersonReg> findPerson(Person person) {
        try {
            return repository.findByPerson(person);
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    public Optional<PlanetPersonReg> findByIds(Person person) {
        try {
            return repository.findByPerson(person);
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    public Iterable<PlanetPersonReg> findAll() {
        Iterable<PlanetPersonReg> planetPersonRegs;
        try {
            planetPersonRegs = repository.findAll();
            return planetPersonRegs;
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }
}
