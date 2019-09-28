package com.samsolutions.service;

import com.samsolutions.dto.RoleDTO;
import com.samsolutions.dto.data.RoleDataDTO;
import com.samsolutions.dto.data.UserDTO;
import com.samsolutions.dto.data.UserDataDTO;
import com.samsolutions.dto.form.RoleFormDTO;
import com.samsolutions.dto.form.UserFormDTO;
import com.samsolutions.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
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
     * @param formDTO RoleFormDTO with data to be set.
     */
    void save(RoleFormDTO formDTO);

    /**
     * Method for find role by id.
     *
     * @param id id of desired role.
     * @return RoleDTO.
     */
    RoleDataDTO findById(Long id);

    Set<Role> findRolesById(Long[] ids);

    /**
     * Method for getting roles from table.
     *
     * @return List<RoleDTO>.
     */
    List<RoleDataDTO> getPage(Integer pageNo, Integer pageSize, Boolean desc, String sort);

    /**
     * Method for delete role by id.
     *
     * @param id id of desired role.
     */
    void deleteRole(Long id);

    List<RoleDataDTO> getRolesByUser(UserFormDTO formDTO);

    List<RoleDataDTO> findAll();

    RoleDataDTO findRoleByName(String name);

    Map<String, Object> getMapAndPage(Integer pageNo, Integer pageSize, Boolean desc, String sort); //todo, optimize
}
