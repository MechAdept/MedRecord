package com.samsolutions.dto.form;

import java.util.Arrays;
import java.util.Objects;

public class RoleFormDTO {

    private Long id;

    private String name;

    private String description;

    private Long[] usersId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long[] getUsers() {
        return usersId;
    }

    public void setUsers(Long[] users) {
        this.usersId = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleFormDTO that = (RoleFormDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Arrays.equals(usersId, that.usersId);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, description);
        result = 31 * result + Arrays.hashCode(usersId);
        return result;
    }
}
