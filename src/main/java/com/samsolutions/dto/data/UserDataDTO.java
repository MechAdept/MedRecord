package com.samsolutions.dto.data;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

public class UserDataDTO {

    private Long id;

    private String username;

    private String password;

    private String name;

    private String surname;

    private String patronymic;

    private String telephone;

    private LocalDateTime birth;

    private Boolean sex;

    private String img;

    private Set<RoleDataDTO> roles;

    private Set<TicketDataDTO> patientTickets;

    private Set<TicketDataDTO> doctorTickets;

    private HealthDataDTO health;

    public UserDataDTO(String username, String password, Set<RoleDataDTO> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public UserDataDTO() {
    }

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

    public Set<RoleDataDTO> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDataDTO> roles) {
        this.roles = roles;
    }

    public Set<TicketDataDTO> getPatientTicket() {
        return patientTickets;
    }

    public void setPatientTicket(Set<TicketDataDTO> patientTicket) {
        this.patientTickets = patientTicket;
    }

    public Set<TicketDataDTO> getDoctorTicket() {
        return doctorTickets;
    }

    public void setDoctorTicket(Set<TicketDataDTO> doctorTicket) {
        this.doctorTickets = doctorTicket;
    }

    public HealthDataDTO getHealth() {
        return health;
    }

    public void setHealth(HealthDataDTO health) {
        this.health = health;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDataDTO that = (UserDataDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(patronymic, that.patronymic) &&
                Objects.equals(telephone, that.telephone) &&
                Objects.equals(birth, that.birth) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(img, that.img) &&
                Objects.equals(roles, that.roles) &&
                Objects.equals(patientTickets, that.patientTickets) &&
                Objects.equals(doctorTickets, that.doctorTickets) &&
                Objects.equals(health, that.health);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, name, surname, patronymic, telephone, birth, sex, img, roles, patientTickets, doctorTickets, health);
    }
}
