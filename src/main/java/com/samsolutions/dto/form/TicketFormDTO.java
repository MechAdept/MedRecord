package com.samsolutions.dto.form;

import java.util.Objects;

/**
 * DataTransferObject for Ticket entity.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.client.dto
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

public class TicketFormDTO {

    private Long id;

    private Long patientId;

    private Long doctorId;

    private String datetime;

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

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketFormDTO that = (TicketFormDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(patientId, that.patientId) &&
                Objects.equals(doctorId, that.doctorId) &&
                Objects.equals(datetime, that.datetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patientId, doctorId, datetime);
    }
}