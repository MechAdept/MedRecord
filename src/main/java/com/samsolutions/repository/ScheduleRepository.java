package com.samsolutions.repository;

import com.samsolutions.entity.Schedule;
import com.samsolutions.entity.Ticket;
import com.samsolutions.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query(value = "select s from Schedule s where s.doctor = ?1 and s.datetime between ?2 and ?3")
    List<Schedule> getDayByDoctorAndDates(User doctor, LocalDateTime from, LocalDateTime to);

//    @Query(value = "select s from Schedule s where s.datetime between ?1 and ?2")
//    List<Schedule> getAllBetweenDateTimes(LocalDateTime from, LocalDateTime to);
//
//    @Query(value = "select s from Schedule s inner join s.ticket where s.datetime <= ?1")
//    List<Schedule> asd(LocalDateTime localDateTime);

    Schedule findByTicketIs(Ticket ticket);
}
