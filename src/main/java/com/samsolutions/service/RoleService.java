package com.samsolutions.service;

import com.samsolutions.dto.RoleDTO;
import com.samsolutions.dto.UserDTO;
import org.springframework.stereotype.Service;

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

    Set<RoleDTO> findRolesById(Long[] rolesId);

    /**
     * Method for getting roles from table.
     *
     * @return List<RoleDTO>.
     */
    List<RoleDTO> getPage(Integer pageNo, Integer pageSize, Boolean desc, String sort);

    Long getPageCount(Integer pageSize);

    Long getTotalCount();

    /**
     * Method for delete role by id.
     *
     * @param id id of desired role.
     */
    void deleteRole(Long id);

    List<RoleDTO> getRolesByUser(UserDTO userDTO);

    List<RoleDTO> findAll();

    RoleDTO findRoleByName(String name);
}
