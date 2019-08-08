package com.samsolutions.entity;

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
import javax.persistence.Table;
import javax.persistence.Transient;

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

    @Transient
    private String passwordConfirm;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private Set<Ticket> patientTicket;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private Set<Ticket> doctorTicket;

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
     * Returns username.
     *
     * @return String.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username String to be set.
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * Returns password.
     *
     * @return String.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password String to be set.
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Returns passwordConfirm.
     *
     * @return String.
     */
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    /**
     * Sets passwordConfirm.
     *
     * @param passwordConfirm String to be set.
     */
    public void setPasswordConfirm(final String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    /**
     * Returns tickets of patient.
     *
     * @return Set<TicketDTO>.
     */
    public Set<Ticket> getPatientTicket() {
        return patientTicket;
    }

    /**
     * Sets tickets for patient.
     *
     * @param patientTicket Set<TicketDTO> to be set.
     */
    public void setPatientTicket(final Set<Ticket> patientTicket) {
        this.patientTicket = patientTicket;
    }

    /**
     * Returns tickets of doctor.
     *
     * @return Set<TicketDTO>.
     */
    public Set<Ticket> getDoctorTicket() {
        return doctorTicket;
    }

    /**
     * Sets tickets for doctor.
     *
     * @param doctorTicket Set<RoleDTO> to be set.
     */
    public void setDoctorTicket(final Set<Ticket> doctorTicket) {
        this.doctorTicket = doctorTicket;
    }

    /**
     * Returns roles of user.
     *
     * @return Set<Role>.
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * Sets roles for user.
     *
     * @param roles Set<Role> to be set.
     */
    public void setRoles(final Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
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
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}