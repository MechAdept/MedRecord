package com.samsolutions.dto;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * DataTransferObject for Ticket entity.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.dto
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

public class TicketDTO {
    private Long id;

    private UserDTO patient;

    private Long patientId;

    private UserDTO doctor;

    private Long doctorId;

    private LocalDateTime datetime;

    private String datetimeString;

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
    public UserDTO getPatient() {
        return patient;
    }

    /**
     * Sets patient.
     *
     * @param patient UserDTO to be set.
     */
    public void setPatient(final UserDTO patient) {
        this.patient = patient;
    }

    /**
     * Returns doctor.
     *
     * @return UserDTO.
     */
    public UserDTO getDoctor() {
        return doctor;
    }

    /**
     * Sets doctor.
     *
     * @param doctor UserDTO to be set.
     */
    public void setDoctor(final UserDTO doctor) {
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

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDatetimeString() {
        return datetimeString;
    }

    public void setDatetimeString(String datetimeString) {

    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TicketDTO ticketDTO = (TicketDTO) o;
        return Objects.equals(id, ticketDTO.id) &&
                Objects.equals(patient, ticketDTO.patient) &&
                Objects.equals(doctor, ticketDTO.doctor) &&
                Objects.equals(datetime, ticketDTO.datetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patient, doctor, datetime);
    }
}
