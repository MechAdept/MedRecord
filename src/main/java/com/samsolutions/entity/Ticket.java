package com.samsolutions.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity

@Table(name = "ticket", schema = "medrecord")
public class Ticket {
    private Long id;
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User patient;
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User doctor;
    private Timestamp datetime;
    private Byte attendance;
    @OneToOne(mappedBy = "visit")
    private Visit visit;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    @Column(name = "attendance", nullable = true)
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
