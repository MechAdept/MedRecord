package com.samsolutions.service;

import com.samsolutions.dto.RoleDTO;
import com.samsolutions.dto.UserDTO;
import com.samsolutions.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User service determine methods for working with user table.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.service
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Service
public interface UserService {
    /**
     * Method for create user.
     *
     * @param userDTO UserDTO with parameters to be set.
     */
    void save(UserDTO userDTO);

    /**
     * Method for getting users from table.
     *
     * @return List<UserDTO>.
     */
    List<UserDTO> getUsers();

    /**
     * Method for find user by id.
     *
     * @param id id of desired user.
     * @return UserDTO.
     */
    UserDTO findUserById(Long id);

    /**
     * Method for find user by username.
     *
     * @param username username of desired user.
     * @return UserDTO.
     */
    User findByUsername(String username);

    /**
     * Method for delete user by id.
     *
     * @param id id of desired user.
     */
    void delete(Long id);

    List<UserDTO> getPage(Integer pageNo, Integer pageSize, Boolean idReverse);

    Long getPageCount(Integer pageSize);

    Long getTotalCount();

    UserDTO findUserWithRolesById(Long id);

    void deleteRoleFromUserById(Long userId, Long RoleId);

    List<UserDTO> findUsersByRole(RoleDTO roleDTO);
}