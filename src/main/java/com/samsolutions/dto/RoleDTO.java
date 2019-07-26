package com.samsolutions.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Set;

/**
 * DataTransferObject for Role entity.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.dto
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

public class RoleDTO {
    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "name")
    private String name;

    @JsonIgnore
    private Set<UserDTO> users;

    /**
     * Returns id.
     *
     * @return Long.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id Long to be set.
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Returns name of user.
     *
     * @return String.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name String to be set.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Returns Set of users.
     *
     * @return Set<UserDTO>.
     */
    public Set<UserDTO> getUsers() {
        return users;
    }

    /**
     * Sets users.
     *
     * @param users Set<UserDTO> to be set.
     */
    public void setUsers(final Set<UserDTO> users) {
        this.users = users;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
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