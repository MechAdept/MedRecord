package com.samsolutions.repository;

import com.samsolutions.entity.Health;
import com.samsolutions.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * The Health repository provides ready-made methods for working with health table.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.repository
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Repository
public interface HealthRepository extends JpaRepository<Health, Long> {

    Health findHealthByPatient(User patient);

    void deleteHealthByPatient(User patient);
}
