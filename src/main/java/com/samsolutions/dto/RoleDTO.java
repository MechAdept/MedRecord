package com.samsolutions.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsolutions.entity.User;
import com.samsolutions.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Objects;
import java.util.Set;

public class RoleDTO extends DTOEssential{
    @JsonProperty(value = "name")
    private String name;
    @JsonIgnore
    private Set<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void setUsers(String user){
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleDTO roleDTO = (RoleDTO) o;
        return Objects.equals(id, roleDTO.id) &&
                Objects.equals(name, roleDTO.name) &&
                Objects.equals(users, roleDTO.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, users);
    }
}
