package com.samsolutions.converter;

import com.samsolutions.dto.RoleDTO;
import com.samsolutions.dto.UserDTO;
import com.samsolutions.entity.Role;
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

        Set<Role> roleSet = user.getRoles();

        userDTO.setRoles(roleConverter.entitiesToDtoSet(roleSet));
        userDTO.setPassword(user.getPassword());
        userDTO.setUsername(user.getUsername());
        return userDTO;
    }

    @Override
    public User dtoToEntity(final UserDTO source) {
        User target = new User();
        target.setId(source.getId());
        target.setPassword(source.getPassword());
        target.setUsername(source.getUsername());
        if(source.getRoles() != null) {
            Set<RoleDTO> DTOSet = source.getRoles();
            target.setRoles(roleConverter.dtoSetToEntities(DTOSet));
        }
        return target;
    }

    @Override
    public Set<UserDTO> entitiesToDtoSet(final Set<User> userSet) {
        Set<UserDTO> userDTOSet = new HashSet<>();
        for (User source : userSet) {
            UserDTO target = entityToDTO(source);
            userDTOSet.add(target);
        }
        return userDTOSet;
    }

    @Override
    public Set<User> dtoSetToEntities(final Set<UserDTO> userDTOSet) {
        Set<User> userSet = new HashSet<>();
        for (UserDTO source : userDTOSet) {
            User target = dtoToEntity(source);
            userSet.add(target);
        }
        return userSet;
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
