package com.samsolutions.dto.form;

import java.util.Arrays;
import java.util.Objects;

public class UserFormDTO {

    private Long id;

    private String username;

    private String password;

    private String passwordConfirm;

    private String name;

    private String surname;

    private String patronymic;

    private String telephone;

    private String birth;

    private Boolean sex;

    private Long[] rolesId;

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

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Long[] getRolesId() {
        return rolesId;
    }

    public void setRolesId(Long[] rolesId) {
        this.rolesId = rolesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserFormDTO that = (UserFormDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(passwordConfirm, that.passwordConfirm) &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(patronymic, that.patronymic) &&
                Objects.equals(telephone, that.telephone) &&
                Objects.equals(birth, that.birth) &&
                Objects.equals(sex, that.sex) &&
                Arrays.equals(rolesId, that.rolesId);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, username, password, passwordConfirm, name, surname, patronymic, telephone, birth, sex);
        result = 31 * result + Arrays.hashCode(rolesId);
        return result;
    }
}
