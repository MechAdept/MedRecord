package com.samsolutions.service;

import com.samsolutions.dto.RoleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Role service determine methods for working with role table.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.service
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Service
public interface RoleService {
    /**
     * Method for create role.
     *
     * @param role RoleDTO with name to be set.
     */
    void save(RoleDTO role);

    /**
     * Method for find role by id.
     *
     * @param id id of desired role.
     * @return RoleDTO.
     */
    RoleDTO findRoleById(Long id);

    /**
     * Method for getting roles from table.
     *
     * @return List<RoleDTO>.
     */
    List<RoleDTO> getRoles();

    /**
     * Method for update role.
     *
     * @param role RoleDTO with parameters to be set.
     */
    void update(RoleDTO role);

    /**
     * Method for delete role by id.
     *
     * @param id id of desired role.
     */
    void deleteRole(Long id);
}
