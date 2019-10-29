package com.samsolutions.dto.data;

import java.time.LocalDateTime;
import java.util.Objects;

public class ScheduleDataDTO {

    private Long id;

    private UserDataDTO doctor;

    private TicketDataDTO ticket;

    private LocalDateTime datetime;

    private Boolean available;

    public ScheduleDataDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDataDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(UserDataDTO doctor) {
        this.doctor = doctor;
    }

    public TicketDataDTO getTicket() {
        return ticket;
    }

    public void setTicket(TicketDataDTO ticket) {
        this.ticket = ticket;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
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
        ScheduleDataDTO that = (ScheduleDataDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(doctor, that.doctor) &&
                Objects.equals(ticket, that.ticket) &&
                Objects.equals(datetime, that.datetime) &&
                Objects.equals(available, that.available);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, doctor, ticket, datetime, available);
    }
}
