package com.samsolutions.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Ticket Entity.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.entity
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient")
    private User patient;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor")
    private User doctor;

    @Column(name = "datetime")
    private LocalDateTime datetime;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id", referencedColumnName = "ticket")
    private Visit visit;

    @Column(name = "attendance")
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

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
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
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) &&
                Objects.equals(patient, ticket.patient) &&
                Objects.equals(doctor, ticket.doctor) &&
                Objects.equals(datetime, ticket.datetime) &&
                Objects.equals(visit, ticket.visit) &&
                Objects.equals(attendance, ticket.attendance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patient, doctor, datetime, visit, attendance);
    }
}
