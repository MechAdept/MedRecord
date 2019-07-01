package com.samsolutions.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity

@Table(name = "Visit", schema = "medrecord")
public class Visit {
    private int id;
    private Integer ticket;
    private Timestamp datetime;
    private String complaint;
    private String examination;
    private String diagnosis;
    private String treatment;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ticket", nullable = true)
    public Integer getTicket() {
        return ticket;
    }

    public void setTicket(Integer ticket) {
        this.ticket = ticket;
    }

    @Basic
    @Column(name = "datetime", nullable = true)
    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    @Basic
    @Column(name = "complaint", nullable = true, length = -1)
    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    @Basic
    @Column(name = "examination", nullable = true, length = -1)
    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

    @Basic
    @Column(name = "diagnosis", nullable = true, length = -1)
    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Basic
    @Column(name = "treatment", nullable = true, length = -1)
    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return id == visit.id &&
                Objects.equals(ticket, visit.ticket) &&
                Objects.equals(datetime, visit.datetime) &&
                Objects.equals(complaint, visit.complaint) &&
                Objects.equals(examination, visit.examination) &&
                Objects.equals(diagnosis, visit.diagnosis) &&
                Objects.equals(treatment, visit.treatment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ticket, datetime, complaint, examination, diagnosis, treatment);
    }
}
