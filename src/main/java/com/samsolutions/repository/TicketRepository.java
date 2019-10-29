package com.samsolutions.repository;

import com.samsolutions.entity.Ticket;
import com.samsolutions.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

/**
 * The Ticket repository provides ready-made methods for working with ticket table.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.repository
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Long countAllByDoctorOrPatient(User doctor, User patient);

    Page<Ticket> findByDoctorOrPatientEquals(User doctor, User Patient, Pageable pageable);

    Ticket findByPatientAndDatetime(User patient, LocalDateTime dateTime);

    @Query("select t from Ticket t where t.patient = ?1 and t.visit is null")
    Ticket findByPatient(User patient);

    @Query("select t from Ticket t where t.patient = ?1 and t.doctor = ?2 and t.visit is null")
    Ticket findNotClousedCoupon(User patient, User doctor);

//    Page<Ticket> findAllByVisitNotNull();
//
//    Page<Ticket> findAllByVisitIsNull();
}
