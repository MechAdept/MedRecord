package com.samsolutions.repository;

import com.samsolutions.entity.Ticket;
import com.samsolutions.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
}
