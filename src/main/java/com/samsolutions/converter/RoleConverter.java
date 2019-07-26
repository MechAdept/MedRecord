package com.samsolutions.converter;

import com.samsolutions.dto.RoleDTO;
import com.samsolutions.entity.Role;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Converter for Role.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.converter
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

public class RoleConverter implements DTOConverter<Role, RoleDTO> {
    @Override
    public RoleDTO entityToDTO(final Role role) {
        RoleDTO roleDTO = new RoleDTO();
        BeanUtils.copyProperties(role, roleDTO);
        return roleDTO;
    }

    @Override
    public Role dtoToEntity(final RoleDTO roleDTO) {
        Role role = new Role();
        BeanUtils.copyProperties(roleDTO, role);
        return role;
    }

    @Override
    public List<RoleDTO> entitiesToDtoList(final List<Role> entityList) {
        List<RoleDTO> roleDTOList = new ArrayList<>();
        for (Role source : entityList) {
            RoleDTO target = new RoleDTO();
            BeanUtils.copyProperties(source, target);
            roleDTOList.add(target);
        }
        return roleDTOList;
    }

    @Override
    public List<Role> dtoListToEntities(final List<RoleDTO> roleDTOList) {
        List<Role> roleList = new ArrayList<>();
        for (RoleDTO source : roleDTOList) {
            Role target = new Role();
            BeanUtils.copyProperties(source, target);
            roleList.add(target);
        }
        return roleList;
    }

//    @Override
//    public String DTOToJSON(RoleDTO roleDTO) {
//        String json = "";
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            json = mapper.writeValueAsString(roleDTO);
//        } catch (JsonProcessingException e) {
//            System.out.println("Не удалось конвертировать в JSON"); //TODO: Add logger
//        }
//        return json;
//    }
//
//    @Override
//    public RoleDTO JSONToDTO(String json) {
//        ObjectMapper mapper = new ObjectMapper();
//        RoleDTO roleDTO = null;
//        try {
//            roleDTO = mapper.readValue(json, RoleDTO.class);
//        } catch (IOException e) {
//            System.out.println("Не удалось конвертировать в DTO"); //TODO: Add logger
//        }
//        return roleDTO;
//    }
}
