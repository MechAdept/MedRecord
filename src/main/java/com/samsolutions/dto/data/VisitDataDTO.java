package com.samsolutions.dto.data;

import java.time.LocalDateTime;
import java.util.Objects;

public class VisitDataDTO {

    private Long id;

    private LocalDateTime datetime;

    private String complaint;

    private String examination;

    private String diagnosis;

    private String treatment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitDataDTO that = (VisitDataDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(datetime, that.datetime) &&
                Objects.equals(complaint, that.complaint) &&
                Objects.equals(examination, that.examination) &&
                Objects.equals(diagnosis, that.diagnosis) &&
                Objects.equals(treatment, that.treatment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datetime, complaint, examination, diagnosis, treatment);
    }
}
