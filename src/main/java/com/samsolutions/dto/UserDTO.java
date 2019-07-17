package com.samsolutions.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsolutions.entity.Ticket;

import java.util.Objects;
import java.util.Set;

public class UserDTO {
    @JsonProperty(value = "id")
    Long id;

    @JsonProperty(value = "username")
    private String username;
    @JsonProperty(value = "password")
    private String password;
    @JsonIgnore
    private String passwordConfirm;
    @JsonProperty(value = "roles")
    private Set<RoleDTO> roles;
    @JsonProperty(value = "patient")
    private Set<Ticket> patientTicket;
    @JsonProperty(value = "doctor")
    private Set<RoleDTO> doctorTicket;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDTO> roles) {
        this.roles = roles;
    }

    public Set<Ticket> getPatientTicket() {
        return patientTicket;
    }

    public void setPatientTicket(Set<Ticket> patientTicket) {
        this.patientTicket = patientTicket;
    }

    public Set<RoleDTO> getDoctorTicket() {
        return doctorTicket;
    }

    public void setDoctorTicket(Set<RoleDTO> doctorTicket) {
        this.doctorTicket = doctorTicket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(id, userDTO.id) &&
                Objects.equals(username, userDTO.username) &&
                Objects.equals(password, userDTO.password) &&
                Objects.equals(passwordConfirm, userDTO.passwordConfirm) &&
                Objects.equals(roles, userDTO.roles) &&
                Objects.equals(patientTicket, userDTO.patientTicket) &&
                Objects.equals(doctorTicket, userDTO.doctorTicket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, passwordConfirm, roles, patientTicket, doctorTicket);
    }
}
