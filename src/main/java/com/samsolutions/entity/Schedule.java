package com.samsolutions.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Schedule Entity.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.entity
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "doctor")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User doctor;

    @JoinColumn(name = "ticket")
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Ticket ticket;

    @Column(name = "datetime")
    private LocalDateTime datetime;

    @Column(name = "available")
    private Boolean available;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(id, schedule.id) &&
                Objects.equals(doctor, schedule.doctor) &&
                Objects.equals(ticket, schedule.ticket) &&
                Objects.equals(datetime, schedule.datetime) &&
                Objects.equals(available, schedule.available);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, doctor, ticket, datetime, available);
    }
}
