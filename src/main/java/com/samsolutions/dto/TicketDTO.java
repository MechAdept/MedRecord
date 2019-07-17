package com.samsolutions.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Objects;

public class TicketDTO {
    @JsonProperty(value = "id")
    Long id;

    @JsonProperty(value = "patient")
    private UserDTO patient;

    @JsonProperty(value = "doctor")
    private UserDTO doctor;

    @JsonProperty(value="datetime")
    private LocalDateTime datetime;

    @JsonProperty(value="attendance")
    private Boolean attendance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getPatient() {
        return patient;
    }

    public void setPatient(UserDTO patient) {
        this.patient = patient;
    }

    public UserDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(UserDTO doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public Boolean getAttendance() {
        return attendance;
    }

    public void setAttendance(Boolean attendance) {
        this.attendance = attendance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketDTO ticketDTO = (TicketDTO) o;
        return Objects.equals(id, ticketDTO.id) &&
                Objects.equals(patient, ticketDTO.patient) &&
                Objects.equals(doctor, ticketDTO.doctor) &&
                Objects.equals(datetime, ticketDTO.datetime) &&
                Objects.equals(attendance, ticketDTO.attendance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patient, doctor, datetime, attendance);
    }
}
