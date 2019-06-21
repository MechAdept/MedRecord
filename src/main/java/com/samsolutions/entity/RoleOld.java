//package com.samsolutions.entity;
//
//import javax.persistence.*;
//import java.util.Objects;
//import java.util.Set;
//
//@Entity
//@Table(name = "role", schema = "MedRecord")
//public class Role {
//    private int id;
//    private String role;
//    private Set<User> users;
//
//    @Id
//    @Column(name = "id")
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    @Basic
//    @Column(name = "role")
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Role role1 = (Role) o;
//        return id == role1.id &&
//                Objects.equals(role, role1.role);
//    }
//
//    @OneToMany(mappedBy = "role")
//    public Set<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, role);
//    }
//}
