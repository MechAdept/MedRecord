package com.samsolutions.entity;

import javax.persistence.*;

import java.util.Set;


@Entity
@Table(name = "user", schema = "medrecord")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Transient
    private String passwordConfirm;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

//    @OneToOne(mappedBy="patient")
//    private Health health;
//
//    @OneToOne(mappedBy = "doctor")
//    private Ticket ticket_doctor;
//
//    @OneToOne(mappedBy = "patient")
//    private Ticket ticket_patient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

//    public Health getHealth() {
//        return health;
//    }
//
//    public void setHealth(Health health) {
//        this.health = health;
//    }
//
//    public Ticket getTicket_doctor() {
//        return ticket_doctor;
//    }
//
//    public void setTicket_doctor(Ticket ticket_doctor) {
//        this.ticket_doctor = ticket_doctor;
//    }
//
//    public Ticket getTicket_patient() {
//        return ticket_patient;
//    }
//
//    public void setTicket_patient(Ticket ticket_patient) {
//        this.ticket_patient = ticket_patient;
//    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}