package com.samsolutions.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

/**
 * User Entity.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.entity
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "birth")
    private LocalDateTime birth;

    @Column(name = "sex")
    private Boolean sex;

    @Column(name = "img")
    private String img;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private Set<Ticket> patientTicket;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private Set<Ticket> doctorTicket;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id", referencedColumnName = "patient")
    private Health health;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public LocalDateTime getBirth() {
        return birth;
    }

    public void setBirth(LocalDateTime birth) {
        this.birth = birth;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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

    public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(patronymic, user.patronymic) &&
                Objects.equals(telephone, user.telephone) &&
                Objects.equals(birth, user.birth) &&
                Objects.equals(sex, user.sex) &&
                Objects.equals(img, user.img) &&
                Objects.equals(roles, user.roles) &&
                Objects.equals(patientTicket, user.patientTicket) &&
                Objects.equals(doctorTicket, user.doctorTicket) &&
                Objects.equals(health, user.health);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, name, surname, patronymic, telephone, birth, sex, img, roles, patientTicket, doctorTicket, health);
    }
}