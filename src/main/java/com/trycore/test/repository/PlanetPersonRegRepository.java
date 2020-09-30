package com.trycore.test.repository;

import com.trycore.test.entity.Person;
import com.trycore.test.entity.Planet;
import com.trycore.test.entity.PlanetPersonReg;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlanetPersonRegRepository extends CrudRepository<PlanetPersonReg, Long> {

    Optional<PlanetPersonReg> findByPerson(Person person);

    Optional<PlanetPersonReg> findByPersonAndPlanet(Person person, Planet planet);

}
