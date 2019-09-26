package com.samsolutions.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Visit Entity.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.entity
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Entity
@Table(name = "visit")
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "datetime")
    private LocalDateTime datetime;

    @Column(name = "complaint")
    private String complaint;

    @Column(name = "examination")
    private String examination;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "treatment")
    private String treatment;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket", referencedColumnName = "id")
    private Ticket ticket;

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
    //    @Column(name = "complaint", nullable = true, length = -1)
    public String getComplaint() {
        return complaint;
    }

    /**
     * Returns complaint.
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
    //    @Column(name = "examination", nullable = true, length = -1)
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
    //    @Column(name = "diagnosis", nullable = true, length = -1)
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
     * @return Ticket.
     */
    public Ticket getTicket() {
        return ticket;
    }

    /**
     * Sets ticket.
     *
     * @param ticket Ticket to be set.
     */
    public void setTicket(final Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return Objects.equals(id, visit.id) &&
                Objects.equals(datetime, visit.datetime) &&
                Objects.equals(complaint, visit.complaint) &&
                Objects.equals(examination, visit.examination) &&
                Objects.equals(diagnosis, visit.diagnosis) &&
                Objects.equals(treatment, visit.treatment) &&
                Objects.equals(ticket, visit.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datetime, complaint, examination, diagnosis, treatment, ticket);
    }
}
