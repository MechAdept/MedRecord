package com.samsolutions.repository;

import com.samsolutions.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
}
