package com.trycore.test.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.trycore.test.entity.Person;
import com.trycore.test.entity.Planet;

import javax.validation.constraints.NotNull;

public class PlanetPersonRegRequest {

    @JsonProperty(value = "personId")
    @NotNull(message = "person cannot be null")
    private Long personId;
    @JsonProperty(value = "planetId")
    @NotNull(message = "planet cannot be null")
    private Long planetId;

    public PlanetPersonRegRequest() {
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getPlanetId() {
        return planetId;
    }

    public void setPlanetId(Long planetId) {
        this.planetId = planetId;
    }
}
