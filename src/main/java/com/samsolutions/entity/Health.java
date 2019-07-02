package com.samsolutions.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity

@Table(name = "health", schema = "medrecord")
public class Health {

    private Long id;
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User patient;
    private String photo;
    private Date birth;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "photo", nullable = true, length = 500)
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "birth", nullable = true)
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public User getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
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
