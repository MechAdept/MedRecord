package com.samsolutions.dto.form;

import java.util.Objects;

public class ScheduleFormDTO {

    private Long id;

    private Long doctorId;

    private Long ticketId;

    private String datetime;

    private Boolean available;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleFormDTO that = (ScheduleFormDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(doctorId, that.doctorId) &&
                Objects.equals(ticketId, that.ticketId) &&
                Objects.equals(datetime, that.datetime) &&
                Objects.equals(available, that.available);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, doctorId, ticketId, datetime, available);
    }
}
