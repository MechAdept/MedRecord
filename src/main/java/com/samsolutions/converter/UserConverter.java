package com.samsolutions.converter;

import com.samsolutions.dto.UserDTO;
import com.samsolutions.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Converter for User.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.converter
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Component
public class UserConverter implements DTOConverter<User, UserDTO> {
    @Autowired
    RoleConverter roleConverter;

    @Override
    public UserDTO entityToDTO(final User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setPassword(user.getPassword());
        userDTO.setUsername(user.getUsername());
        try {
            userDTO.setRoles(roleConverter.entitiesToDtoSet(user.getRoles()));
            return userDTO;
        } catch (Exception e) {
            return userDTO;
        }
    }

    @Override
    public User dtoToEntity(final UserDTO source) {
        User target = new User();
        target.setId(source.getId());
        target.setPassword(source.getPassword());
        target.setUsername(source.getUsername());
        try{
            target.setRoles(roleConverter.dtoSetToEntities(source.getRoles()));
        } catch (NullPointerException ne){
            return target;
        }
        return target;
    }

    @Override
    public Set<UserDTO> entitiesToDtoSet(final Set<User> userSet) {
        Set<UserDTO> userDTOSet = new HashSet<>();

        try {
            for (User source : userSet) {
                UserDTO target = entityToDTO(source);
                userDTOSet.add(target);
            }
            return userDTOSet;
        } catch (NullPointerException ne) {
            return userDTOSet;
        }
    }

    @Override
    public Set<User> dtoSetToEntities(final Set<UserDTO> userDTOSet) {
        Set<User> userSet = new HashSet<>();
        try {
            for (UserDTO source : userDTOSet) {
                User target = dtoToEntity(source);
                userSet.add(target);
            }
            return userSet;
        } catch (NullPointerException ne) {
            return userSet;
        }
    }

    @Override
    public List<UserDTO> entitiesToDtoList(List<User> entityList) {
        List<UserDTO> DTOList = new ArrayList<>();
        for (User source : entityList) {
            UserDTO target = entityToDTO(source);
            DTOList.add(target);
        }
        return DTOList;
    }
}
