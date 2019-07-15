package com.samsolutions.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;
import java.util.Objects;

public class HealthDTO {
    @JsonProperty(value = "id")
    Long id;

    @JsonProperty(value = "user")
    private UserDTO user;

    @JsonProperty(value = "photo")
    private String photo;

    @JsonProperty(value = "birth")
    private Date birth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthDTO healthDTO = (HealthDTO) o;
        return Objects.equals(id, healthDTO.id) &&
                Objects.equals(user, healthDTO.user) &&
                Objects.equals(photo, healthDTO.photo) &&
                Objects.equals(birth, healthDTO.birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, photo, birth);
    }
}
