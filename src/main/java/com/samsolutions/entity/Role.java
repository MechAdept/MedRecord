package com.samsolutions.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.Objects;
import java.util.Set;

/**
 * Role Entity.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.entity
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<User> users;

    /**
     * Constructor with parameters for Role.
     *
     * @param name name of new role.
     */
    public Role(final String name) {
        this.name = name;
    }


    /**
     * Constructor for Role.
     */
    public Role() {
    }

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
     * @return Set<User>.
     */
    public Set<User> getUsers() {
        return users;
    }

    /**
     * Sets users.
     *
     * @param users Set<User> to be set.
     */
    public void setUsers(final Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Role role = (Role) o;
        return Objects.equals(id, role.id) &&
                Objects.equals(name, role.name) &&
                Objects.equals(users, role.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}