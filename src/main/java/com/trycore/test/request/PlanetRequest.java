package com.trycore.test.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class PlanetRequest {
    @JsonProperty(value = "name")
    @NotNull(message = "name cannot be null")
    private String name;

    public PlanetRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
