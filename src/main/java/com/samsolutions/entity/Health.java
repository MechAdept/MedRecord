package com.samsolutions.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Health Entity.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.entity
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Entity
@Table(name = "health")
public class Health {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "patient")
    @OneToOne(cascade = CascadeType.MERGE)
    private User patient;

    @Column(name = "photo")
    private String photo;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "birth")
    private LocalDate birth;

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
     * Returns link to photo.
     *
     * @return String.
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * Sets photo.
     *
     * @param photo String (link to photo) to be set.
     */
    public void setPhoto(final String photo) {
        this.photo = photo;
    }

    /**
     * Returns date of birth.
     *
     * @return LocalDate.
     */
    public LocalDate getBirth() {
        return birth;
    }

    /**
     * Sets date of birth.
     *
     * @param birth LocaleDate to be set.
     */
    public void setBirth(final LocalDate birth) {
        this.birth = birth;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Health health = (Health) o;
        return id == health.id &&
                Objects.equals(patient, health.patient) &&
                Objects.equals(photo, health.photo) &&
                Objects.equals(birth, health.birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patient, photo, birth);
    }
}
