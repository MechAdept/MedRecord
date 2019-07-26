package com.samsolutions.repository;

import com.samsolutions.entity.Role;
import com.samsolutions.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The User repository provides ready-made methods for working with user table.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.repository
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Method for find user by username.
     *
     * @param username username to be set.
     * @return User
     */
    User findByUsername(String username);

    /**
     * Method for update user.
     *
     * @param id LocalDateTime to be set.
     * @param password password to be set.
     * @param roleList list of roles to be set.
     * @param username username to be set.
     */
    @Modifying
    @Transactional
    @Query("UPDATE User  u SET u.username = ?2, u.password = ?3, u.roles = ?4 WHERE u.id = ?1")
    void updateUser(Long id, String username, String password, List<Role> roleList);
}
