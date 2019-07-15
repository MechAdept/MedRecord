package com.samsolutions.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsolutions.dto.RoleDTO;
import com.samsolutions.entity.Role;
import org.springframework.beans.BeanUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RoleConverter implements DTOConverter<Role, RoleDTO> {
    @Override
    public RoleDTO EntityToDTO(Role role) {
        RoleDTO roleDTO = new RoleDTO();
        BeanUtils.copyProperties(role, roleDTO);
        return roleDTO;
    }

    @Override
    public Role DTOToEntity(RoleDTO roleDTO) {
        Role role = new Role();
        BeanUtils.copyProperties(roleDTO, role);
        return role;
    }

    @Override
    public List<RoleDTO> EListToDTO(List<Role> entityList) {
        List<RoleDTO> roleDTOList = new ArrayList<>();
        for (Role source : entityList) {
            RoleDTO target = new RoleDTO();
            BeanUtils.copyProperties(source, target);
            roleDTOList.add(target);
        }
        return roleDTOList;
    }

    @Override
    public List<Role> DTOListToEntity(List<RoleDTO> roleDTOList) {
        List<Role> roleList = new ArrayList<>();
        for (RoleDTO source : roleDTOList) {
            Role target = new Role();
            BeanUtils.copyProperties(source, target);
            roleList.add(target);
        }
        return roleList;
    }

    @Override
    public String DTOToJSON(RoleDTO roleDTO) {
        String json = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            json = mapper.writeValueAsString(roleDTO);
        } catch (JsonProcessingException e) {
            System.out.println("Не удалось конвертировать в JSON"); //ДОБАВИТЬ ЛОГГЕР
        }
        return json;
    }

    @Override
    public RoleDTO JSONToDTO(String json) {
        ObjectMapper mapper = new ObjectMapper();
        RoleDTO roleDTO = null;
        try {
            roleDTO = mapper.readValue(json, RoleDTO.class);
        } catch (IOException e) {
            System.out.println("Не удалось конвертировать в DTO"); //ДОБАВИТЬ ЛОГГЕР
        }
        return roleDTO;
    }
}
