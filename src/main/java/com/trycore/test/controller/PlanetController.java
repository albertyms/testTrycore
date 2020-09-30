package com.trycore.test.controller;

import com.trycore.test.entity.Planet;
import com.trycore.test.request.PlanetRequest;
import com.trycore.test.service.PlanetService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/planet")
@CrossOrigin(origins = "http://localhost:4200", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT})
public class PlanetController {
    private Logger logger = LogManager.getLogger(PlanetController.class);

    @Autowired
    PlanetService planetService;

    @PostMapping
    public ResponseEntity create(@Validated @RequestBody PlanetRequest request) {
        try {
            Planet planet = new Planet(request);
            planet = planetService.create(planet);
            return ResponseEntity.ok(planet);
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @Validated @RequestBody PlanetRequest request) {
        try {
            if(planetService.findById(id).isPresent()) {
                return ResponseEntity.ok(planetService.update(id, request));
            } else {
                return (ResponseEntity) ResponseEntity.status(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Planet> findById(@PathVariable Long id) {
        try {
            Planet planet = planetService.findById(id).get();
            return ResponseEntity.ok(planet);
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Planet>> findAll() {
        return ResponseEntity.ok(planetService.findAll());
    }

    @PutMapping("/updateView/{id}")
    public ResponseEntity updateCountView(@PathVariable Long id) {
        try {
            if (planetService.findById(id).isPresent()) {
                return ResponseEntity.ok(planetService.updateViewCount(id, planetService.findById(id).get()));
            } else {
                return new ResponseEntity<>("Planet Not Found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Error:", e);
            return null;
        }
    }

}
