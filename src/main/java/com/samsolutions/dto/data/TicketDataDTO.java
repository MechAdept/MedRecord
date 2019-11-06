package com.samsolutions.dto.data;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * DataTransferObject for Ticket entity.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.server.dto
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

public class TicketDataDTO {

    private Long id;

    private UserDataDTO patient;

    private UserDataDTO doctor;

    private LocalDateTime datetime;

    private VisitDataDTO visit;

    /**
     * Returns id.
     *
     * @return Long.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets userService.
     *
     * @param id Long to be set.
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Returns patient.
     *
     * @return UserDTO.
     */
    public UserDataDTO getPatient() {
        return patient;
    }

    /**
     * Sets patient.
     *
     * @param patient UserDTO to be set.
     */
    public void setPatient(final UserDataDTO patient) {
        this.patient = patient;
    }

    /**
     * Returns doctor.
     *
     * @return UserDTO.
     */
    public UserDataDTO getDoctor() {
        return doctor;
    }

    /**
     * Sets doctor.
     *
     * @param doctor UserDTO to be set.
     */
    public void setDoctor(final UserDataDTO doctor) {
        this.doctor = doctor;
    }

    /**
     * Returns datetime.
     *
     * @return LocalDateTime.
     */
    public LocalDateTime getDatetime() {
        return datetime;
    }

    /**
     * Sets datetime.
     *
     * @param datetime LocalDateTime to be set.
     */
    public void setDatetime(final LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public VisitDataDTO getVisit() {
        return visit;
    }

    public void setVisit(VisitDataDTO visit) {
        this.visit = visit;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TicketDataDTO ticketDataDTO = (TicketDataDTO) o;
        return Objects.equals(id, ticketDataDTO.id) &&
                Objects.equals(patient, ticketDataDTO.patient) &&
                Objects.equals(doctor, ticketDataDTO.doctor) &&
                Objects.equals(datetime, ticketDataDTO.datetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patient, doctor, datetime);
    }
}
