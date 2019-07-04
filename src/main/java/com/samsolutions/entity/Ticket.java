package com.samsolutions.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "ticket", schema = "medrecord")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "patient", referencedColumnName = "id")
    private User patient;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "doctor",referencedColumnName = "id")
    private User doctor;

    @Column(name = "datetime")
    private Timestamp datetime;
    @Column(name = "attendance")
    private Byte attendance;

    @OneToOne(mappedBy = "ticket")
    private Visit visit;

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
    public Byte getAttendance() {
        return attendance;
    }

    public void setAttendance(Byte attendance) {
        this.attendance = attendance;
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

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id &&
                Objects.equals(datetime, ticket.datetime) &&
                Objects.equals(attendance, ticket.attendance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datetime, attendance);
    }
}
