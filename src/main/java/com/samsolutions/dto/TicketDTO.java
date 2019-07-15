package com.samsolutions.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsolutions.entity.User;

import java.time.LocalDateTime;
import java.util.Objects;

public class TicketDTO {
    @JsonProperty(value = "id")
    Long id;

    @JsonProperty(value = "patient")
    private User patient;

    @JsonProperty(value = "doctor")
    private User doctor;

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

    public User getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
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
