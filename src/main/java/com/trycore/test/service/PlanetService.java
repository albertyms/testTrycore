package com.trycore.test.service;

import com.trycore.test.entity.Planet;
import com.trycore.test.repository.PlanetRepository;
import com.trycore.test.request.PlanetRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PlanetService {
    private Logger logger = LogManager.getLogger(PlanetService.class);

    @Autowired
    PlanetRepository repository;

    public Planet create(Planet planet) {
        try {
            return repository.save(planet);
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    public Planet update(Long id, PlanetRequest request) {
        try {
            Planet planetUpdate = new Planet(request);
            planetUpdate.setId(id);
            return repository.save(planetUpdate);
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    public Optional<Planet> findById(Long id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    public Iterable<Planet> findAll() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    public Planet updateViewCount(Long id, Planet planet) {
        try {
            planet.setCountView(planet.getCountView()+1);
            return repository.save(planet);
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

}
