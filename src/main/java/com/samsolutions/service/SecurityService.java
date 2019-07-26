package com.samsolutions.service;

import org.springframework.stereotype.Service;

/**
 * Security service defines methods for user authorization.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.service
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Service
public interface SecurityService {
    /**
     * Method for find health by id.
     *
     * @return HealthDTO.
     */
    String findLoggedInUsername();

    void autologin(String username, String password);
}