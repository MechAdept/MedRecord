package com.samsolutions.repository;

import com.samsolutions.entity.Schedule;
import com.samsolutions.entity.Ticket;
import com.samsolutions.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query(value = "select s from Schedule s where s.doctor = ?1 and s.datetime between ?2 and ?3")
    List<Schedule> getDayByDoctorAndDates(User doctor, LocalDateTime from, LocalDateTime to);

    Schedule findByTicketIs(Ticket ticket);

    void deleteAllByDatetimeBefore(LocalDateTime before);

    List<Schedule> getAllByDoctorIs(User doctor);
}
