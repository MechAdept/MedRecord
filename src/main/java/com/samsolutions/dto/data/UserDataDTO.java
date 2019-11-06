package com.samsolutions.dto.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class UserDataDTO {

    private Long id;

    @JsonIgnore
    private String username;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private String name;

    @JsonIgnore
    private String surname;

    @JsonIgnore
    private String patronymic;

    @JsonIgnore
    private String telephone;

    @JsonIgnore
    private Date birth;

    @JsonIgnore
    private Boolean sex;

    @JsonIgnore
    private String img;

    @JsonIgnore
    private List<RoleDataDTO> roles;

    @JsonIgnore
    private List<TicketDataDTO> patientTickets;

    @JsonIgnore
    private List<TicketDataDTO> doctorTickets;

    @JsonIgnore
    private HealthDataDTO health;

    public UserDataDTO(String username, String password, List<RoleDataDTO> roles) {
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
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

    public List<RoleDataDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDataDTO> roles) {
        this.roles = roles;
    }

    public List<TicketDataDTO> getPatientTickets() {
        return patientTickets;
    }

    public void setPatientTickets(List<TicketDataDTO> patientTickets) {
        this.patientTickets = patientTickets;
    }

    public List<TicketDataDTO> getDoctorTickets() {
        return doctorTickets;
    }

    public void setDoctorTickets(List<TicketDataDTO> doctorTickets) {
        this.doctorTickets = doctorTickets;
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
