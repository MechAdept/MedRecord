package com.samsolutions.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsolutions.dto.RoleDTO;
import com.samsolutions.dto.UserDTO;
import com.samsolutions.entity.Role;
import com.samsolutions.entity.User;
import org.springframework.beans.BeanUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserConverter implements DTOConverter<User, UserDTO> {
    @Override
    public UserDTO EntityToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    @Override
    public User DTOToEntity(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return user;
    }

    @Override
    public List<UserDTO> EListToDTO(List<User> userList) {
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User source : userList) {
            UserDTO target = new UserDTO();
            BeanUtils.copyProperties(source, target);
            userDTOList.add(target);
        }
        return userDTOList;
    }

    @Override
    public List<User> DTOListToEntity(List<UserDTO> userDTOList) {
        List<User> userList = new ArrayList<>();
        for (UserDTO source : userDTOList) {
            User target = new User();
            BeanUtils.copyProperties(source, target);
            userList.add(target);
        }
        return userList;
    }

    @Override
    public String DTOToJSON(UserDTO userDTO) {
        String json = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            json = mapper.writeValueAsString(userDTO);
        } catch (JsonProcessingException e) {
            System.out.println("Не удалось конвертировать в JSON"); //ДОБАВИТЬ ЛОГГЕР
        }
        return json;
    }

    @Override
    public UserDTO JSONToDTO(String json) {
        ObjectMapper mapper = new ObjectMapper();
        UserDTO userDTO = null;
        try {
            userDTO = mapper.readValue(json, UserDTO.class);
        } catch (IOException e) {
            System.out.println("Не удалось конвертировать в DTO"); //ДОБАВИТЬ ЛОГГЕР
        }
        return userDTO;
    }
}
