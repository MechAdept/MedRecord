package com.samsolutions.repository;

import com.samsolutions.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Role repository provides ready-made methods for working with role table.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.repository
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    /**
     * Method for update role w/o changing password.
     *
     * @param id id to be set.
     * @param name name to be set.
     */
    @Modifying
    @Transactional
    @Query("UPDATE Role r SET r.name = ?2 WHERE r.id = ?1")
    void updateRole(Long id, String name);

    /**
     * Method for update role w/ changing password.
     *
     * @param id id to be set.
     * @param name name to be set.
     * @param password password to be set.
     */
    @Modifying
    @Transactional
    @Query("UPDATE Role r SET r.name = ?2 WHERE r.id = ?1")
    void updateRole(Long id, String name, String password);

//    Page<Role> getAllById(Pageable pageable);

//    Page<Role> findAllById(Pageable pageable);
}