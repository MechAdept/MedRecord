package com.samsolutions.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class DTOEssential {
    @JsonProperty(value = "id")
    Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
