package com.samsolutions.service;

import com.samsolutions.dto.RoleDTO;
import com.samsolutions.entity.Role;
import com.samsolutions.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Role service determine methods for working with role table.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.service
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Service
@Transactional
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
    @Transactional(readOnly = true)
    RoleDTO findRoleById(Long id);

    /**
     * Method for getting roles from table.
     *
     * @return List<RoleDTO>.
     */
    @Transactional(readOnly = true)
    List<RoleDTO> getRoles();

    /**
     * Method for delete role by id.
     *
     * @param id id of desired role.
     */
    void deleteRole(Long id);

    Set<Role> getRolesEntityByUserId(User user);
}
