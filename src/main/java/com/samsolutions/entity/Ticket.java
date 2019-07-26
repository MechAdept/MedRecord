package com.samsolutions.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

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
    @JoinColumn(name = "patient", referencedColumnName = "id")
    private User patient;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor", referencedColumnName = "id")
    private User doctor;

    @Column(name = "datetime")
    private LocalDateTime datetime;

    @Column(name = "attendance")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean attendance;

    /**
     * Returns id.
     *
     * @return Long.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id Long to be set.
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Returns datetime.
     *
     * @return LocalDateTime.
     */
    public LocalDateTime getDatetime() {
        return datetime;
    }

    /**
     * Sets datetime.
     *
     * @param datetime LocalDateTime to be set.
     */
    public void setDatetime(final LocalDateTime datetime) {
        this.datetime = datetime;
    }

    /**
     * Returns attendance.
     *
     * @return Boolean.
     */
    public Boolean getAttendance() {
        return attendance;
    }

    /**
     * Sets attendance.
     *
     * @param attendance Boolean to be set.
     */
    public void setAttendance(final Boolean attendance) {
        this.attendance = attendance;
    }

    /**
     * Returns patient.
     *
     * @return User.
     */
    public User getPatient() {
        return patient;
    }

    /**
     * Sets patient.
     *
     * @param patient User to be set.
     */
    public void setPatient(final User patient) {
        this.patient = patient;
    }

    /**
     * Returns doctor.
     *
     * @return User.
     */
    public User getDoctor() {
        return doctor;
    }

    /**
     * Sets doctor.
     *
     * @param doctor User to be set.
     */
    public void setDoctor(final User doctor) {
        this.doctor = doctor;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) &&
                Objects.equals(patient, ticket.patient) &&
                Objects.equals(doctor, ticket.doctor) &&
                Objects.equals(datetime, ticket.datetime) &&
                Objects.equals(attendance, ticket.attendance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patient, doctor, datetime, attendance);
    }
}
