package com.samsolutions.entity;


import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "health", schema = "medrecord")
public class Health {
    private Long id;

    @OneToOne
    @JoinColumn(name = "patient", referencedColumnName = "id")
//    @OneToOne(mappedBy="health")
//    @JoinColumn(name="id", referencedColumnName = "patient")
    private User patient;

    @Column(name = "photo")
    private String photo;
    @Column(name = "birth")
    private Date birth;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    @Basic
//    @Column(name = "photo", nullable = true, length = 500)
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

//    @Basic
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public User getUser() {
        return patient;
    }

    public void setUser(User user) {
        this.patient = user;
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
