//package com.samsolutions.entity;
//
//import javax.persistence.*;
//import java.util.Objects;
//import java.util.Set;
//
//@Entity
//@Table(name = "user", schema = "MedRecord")
//public class User {
//    private int id;
//    private String login;
//    private String password;
//    private String mail;
//    private String type;
//    private String passwordConfirm;
//    private Role role;
//
//    @Id
//    @Column(name = "id", nullable = false)
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    @Id
//    @Basic
//    @Column(name = "login", nullable = true, length = 45)
//    public String getLogin() {
//        return login;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }
//
//    @Basic
//    @Column(name = "password", nullable = true, length = 45)
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    @Basic
//    @Column(name = "mail", nullable = true, length = 255)
//    public String getMail() {
//        return mail;
//    }
//
//    public void setMail(String mail) {
//        this.mail = mail;
//    }
//
//    @Basic
//    @Column(name = "type", nullable = true, length = 45)
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User that = (User) o;
//        return id == that.id &&
//                Objects.equals(login, that.login) &&
//                Objects.equals(password, that.password) &&
//                Objects.equals(mail, that.mail) &&
//                Objects.equals(type, that.type);
//    }
//
//    @ManyToOne
//    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, login, password, mail, type);
//    }
//
//    @Transient
//    public String getPasswordConfirm() {
//        return passwordConfirm;
//    }
//
//    public void setPasswordConfirm(String passwordConfirm) {
//        this.passwordConfirm = passwordConfirm;
//    }
//
//}