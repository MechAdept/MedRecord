package com.samsolutions.service;

import com.samsolutions.dto.data.RoleDataDTO;
import com.samsolutions.dto.form.RoleFormDTO;
import com.samsolutions.dto.form.UserFormDTO;
import com.samsolutions.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Role service determine methods for working with role table.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.service
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Service
public interface RoleService{

    /**
     * Method for find role by id.
     *
     * @param id id of desired role.
     * @return RoleDTO.
     */
    RoleDataDTO findById(Long id);

    List<Role> findByIds(Long[] ids);

    List<RoleDataDTO> findAll();
}
