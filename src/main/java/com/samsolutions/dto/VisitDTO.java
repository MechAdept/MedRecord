package com.samsolutions.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsolutions.entity.Ticket;

import java.time.LocalDateTime;
import java.util.Objects;

public class VisitDTO {
    @JsonProperty(value = "id")
    Long id;

    @JsonProperty(value = "datetime")
    private LocalDateTime datetime;

    @JsonProperty(value = "complaint")
    private String complaint;

    @JsonProperty(value = "examination")
    private String examination;

    @JsonProperty(value = "diagnosis")
    private String diagnosis;

    @JsonProperty(value = "treatment")
    private String treatment;

    @JsonProperty(value = "ticket")
    private Ticket ticket;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitDTO visitDTO = (VisitDTO) o;
        return Objects.equals(id, visitDTO.id) &&
                Objects.equals(datetime, visitDTO.datetime) &&
                Objects.equals(complaint, visitDTO.complaint) &&
                Objects.equals(examination, visitDTO.examination) &&
                Objects.equals(diagnosis, visitDTO.diagnosis) &&
                Objects.equals(treatment, visitDTO.treatment) &&
                Objects.equals(ticket, visitDTO.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datetime, complaint, examination, diagnosis, treatment, ticket);
    }
}
