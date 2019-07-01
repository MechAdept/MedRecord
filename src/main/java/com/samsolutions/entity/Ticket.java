package com.samsolutions.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity

@Table(name = "Ticket", schema = "medrecord")
public class Ticket {
    private int id;
    private Timestamp datetime;
    private Byte attendance;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
