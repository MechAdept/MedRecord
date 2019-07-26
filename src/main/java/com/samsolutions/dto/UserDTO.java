package com.samsolutions.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Set;

/**
 * DataTransferObject for User entity.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.dto
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

public class UserDTO {
    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "username")
    private String username;
    @JsonProperty(value = "password")
    private String password;
    @JsonIgnore
    private String passwordConfirm;
    @JsonProperty(value = "roles")
    private Set<RoleDTO> roles;
    @JsonProperty(value = "patient")
    private Set<TicketDTO> patientTicket;
    @JsonProperty(value = "doctor")
    private Set<TicketDTO> doctorTicket;

    /**
     * Returns id.
     *
     * @return Long.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id Long to be set.
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Returns username.
     *
     * @return String.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username String to be set.
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * Returns password.
     *
     * @return String.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password String to be set.
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Returns passwordConfirm.
     *
     * @return String.
     */
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    /**
     * Sets passwordConfirm.
     *
     * @param passwordConfirm String to be set.
     */
    public void setPasswordConfirm(final String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    /**
     * Returns roles of user.
     *
     * @return Set<RoleDTO>.
     */
    public Set<RoleDTO> getRoles() {
        return roles;
    }

    /**
     * Sets roles for user.
     *
     * @param roles Set<RoleDTO> to be set.
     */
    public void setRoles(final Set<RoleDTO> roles) {
        this.roles = roles;
    }

    /**
     * Returns tickets of patient.
     *
     * @return Set<TicketDTO>.
     */
    public Set<TicketDTO> getPatientTicket() {
        return patientTicket;
    }

    /**
     * Sets tickets for patient.
     *
     * @param patientTicket Set<TicketDTO> to be set.
     */
    public void setPatientTicket(final Set<TicketDTO> patientTicket) {
        this.patientTicket = patientTicket;
    }

    /**
     * Returns tickets of doctor.
     *
     * @return Set<TicketDTO>.
     */
    public Set<TicketDTO> getDoctorTicket() {
        return doctorTicket;
    }

    /**
     * Sets tickets for doctor.
     *
     * @param doctorTicket Set<RoleDTO> to be set.
     */
    public void setDoctorTicket(final Set<TicketDTO> doctorTicket) {
        this.doctorTicket = doctorTicket;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
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
