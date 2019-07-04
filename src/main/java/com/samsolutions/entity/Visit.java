package com.samsolutions.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity

@Table(name = "visit", schema = "medrecord")
public class Visit {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "datetime", nullable = true)
    private Timestamp datetime;
    @Column(name="complaint")
    private String complaint;
    @Column(name="examination")
    private String examination;
    @Column(name="diagnosis")
    private String diagnosis;
    @Column(name="treatment")
    private String treatment;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    @Basic
//    @Column(name = "complaint", nullable = true, length = -1)
    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    @Basic
//    @Column(name = "examination", nullable = true, length = -1)
    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

    @Basic
//    @Column(name = "diagnosis", nullable = true, length = -1)
    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Basic
//    @Column(name = "treatment", nullable = true, length = -1)
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
