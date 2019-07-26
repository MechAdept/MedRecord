package com.samsolutions.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * DataTransferObject for Visit entity.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.dto
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

public class VisitDTO {
    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "datetime")
    private LocalDateTime datetime;

    @JsonProperty(value = "complaint")
    private String complaint;

    @JsonProperty(value = "examination")
    private String examination;

    @JsonProperty(value = "diagnosis")
    private String diagnosis;

    @JsonProperty(value = "treatment")
    private String treatment;

    @JsonProperty(value = "ticket")
    private TicketDTO ticket;

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

    /**
     * Returns complaint.
     *
     * @return String.
     */
    public String getComplaint() {
        return complaint;
    }

    /**
     * Sets datetime.
     *
     * @param complaint String to be set.
     */
    public void setComplaint(final String complaint) {
        this.complaint = complaint;
    }

    /**
     * Returns examination.
     *
     * @return String.
     */
    public String getExamination() {
        return examination;
    }

    /**
     * Sets examination.
     *
     * @param examination String to be set.
     */
    public void setExamination(final String examination) {
        this.examination = examination;
    }

    /**
     * Returns diagnosis.
     *
     * @return String.
     */
    public String getDiagnosis() {
        return diagnosis;
    }

    /**
     * Sets diagnosis.
     *
     * @param diagnosis String to be set.
     */
    public void setDiagnosis(final String diagnosis) {
        this.diagnosis = diagnosis;
    }

    /**
     * Returns treatment.
     *
     * @return String.
     */
    public String getTreatment() {
        return treatment;
    }

    /**
     * Sets treatment.
     *
     * @param treatment String to be set.
     */
    public void setTreatment(final String treatment) {
        this.treatment = treatment;
    }

    /**
     * Returns ticket.
     *
     * @return TicketDTO.
     */
    public TicketDTO getTicket() {
        return ticket;
    }

    /**
     * Sets ticket.
     *
     * @param ticket TicketDTO to be set.
     */
    public void setTicket(final TicketDTO ticket) {
        this.ticket = ticket;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VisitDTO visitDTO = (VisitDTO) o;
        return Objects.equals(id, visitDTO.id) &&
                Objects.equals(datetime, visitDTO.datetime) &&
                Objects.equals(complaint, visitDTO.complaint) &&
                Objects.equals(examination, visitDTO.examination) &&
                Objects.equals(diagnosis, visitDTO.diagnosis) &&
                Objects.equals(treatment, visitDTO.treatment) &&
                Objects.equals(ticket, visitDTO.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datetime, complaint, examination, diagnosis, treatment, ticket);
    }
}
