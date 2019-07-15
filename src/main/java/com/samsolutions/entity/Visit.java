package com.samsolutions.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "visit", schema = "medrecord")
public class Visit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "datetime")
    private LocalDateTime datetime;

    @Column(name="complaint")
    private String complaint;

    @Column(name="examination")
    private String examination;

    @Column(name="diagnosis")
    private String diagnosis;

    @Column(name="treatment")
    private String treatment;

    @JoinColumn(referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
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

    //    @Column(name = "complaint", nullable = true, length = -1)
    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

//    @Column(name = "examination", nullable = true, length = -1)
    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

//    @Column(name = "diagnosis", nullable = true, length = -1)
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
