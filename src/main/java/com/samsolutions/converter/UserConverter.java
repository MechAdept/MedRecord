package com.samsolutions.converter;

import com.samsolutions.dto.UserDTO;
import com.samsolutions.entity.User;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Converter for User.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.converter
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

public class UserConverter implements DTOConverter<User, UserDTO> {
    @Override
    public UserDTO entityToDTO(final User user) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    @Override
    public User dtoToEntity(final UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return user;
    }

    @Override
    public List<UserDTO> entitiesToDtoList(final List<User> userList) {
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User source : userList) {
            UserDTO target = new UserDTO();
            BeanUtils.copyProperties(source, target);
            userDTOList.add(target);
        }
        return userDTOList;
    }

    @Override
    public List<User> dtoListToEntities(final List<UserDTO> userDTOList) {
        List<User> userList = new ArrayList<>();
        for (UserDTO source : userDTOList) {
            User target = new User();
            BeanUtils.copyProperties(source, target);
            userList.add(target);
        }
        return userList;
    }

//    @Override
//    public String DTOToJSON(UserDTO userDTO) {
//        String json = "";
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            json = mapper.writeValueAsString(userDTO);
//        } catch (JsonProcessingException e) {
//            System.out.println("Не удалось конвертировать в JSON"); //TODO: Add logger
//        }
//        return json;
//    }
//
//    @Override
//    public UserDTO JSONToDTO(String json) {
//        ObjectMapper mapper = new ObjectMapper();
//        UserDTO userDTO = null;
//        try {
//            userDTO = mapper.readValue(json, UserDTO.class);
//        } catch (IOException e) {
//            System.out.println("Не удалось конвертировать в DTO"); //TODO: Add logger
//        }
//        return userDTO;
//    }
}
