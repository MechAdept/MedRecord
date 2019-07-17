package com.samsolutions.entity;

import net.bytebuddy.build.Plugin;

import javax.persistence.*;

import java.util.Set;


@Entity
@Table(name = "user", schema = "medrecord")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    @Transient
    private String passwordConfirm;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    private Set<Ticket> patientTicket;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.EAGER)
    private Set<Ticket> doctorTicket;

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

    public Set<Ticket> getPatientTicket() {
        return patientTicket;
    }

    public void setPatientTicket(Set<Ticket> patientTicket) {
        this.patientTicket = patientTicket;
    }

    public Set<Ticket> getDoctorTicket() {
        return doctorTicket;
    }

    public void setDoctorTicket(Set<Ticket> doctorTicket) {
        this.doctorTicket = doctorTicket;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}