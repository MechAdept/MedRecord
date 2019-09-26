package com.samsolutions.converter;

import com.samsolutions.converter.fromEntity.DataDTOConverter;
import com.samsolutions.dto.data.UserDataDTO;
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
public class UserConverterData implements DataDTOConverter<User, UserDataDTO> {
    @Autowired
    RoleConverterData roleConverter;

    @Override
    public UserDataDTO entityToDataDTO(final User user) {
        UserDataDTO userDTO = new UserDataDTO();
        userDTO.setId(user.getId());
        userDTO.setPassword(user.getPassword());
        userDTO.setUsername(user.getUsername());
        try {
            userDTO.setRoles(roleConverter.entitiesToDataDtoSet(user.getRoles()));
            return userDTO;
        } catch (Exception e) {
            return userDTO;
        }
    }

    @Override
    public User formDtoToEntity(final UserDataDTO source) {
        User target = new User();
        target.setId(source.getId());
        target.setPassword(source.getPassword());
        target.setUsername(source.getUsername());
        try{
            target.setRoles(roleConverter.formDtoSetToEntities(source.getRoles()));
        } catch (NullPointerException ne){
            return target;
        }
        return target;
    }

    @Override
    public Set<UserDataDTO> entitiesToDataDtoSet(final Set<User> userSet) {
        Set<UserDataDTO> userDTOSet = new HashSet<>();

        try {
            for (User source : userSet) {
                UserDataDTO target = entityToDataDTO(source);
                userDTOSet.add(target);
            }
            return userDTOSet;
        } catch (NullPointerException ne) {
            return userDTOSet;
        }
    }

    @Override
    public Set<User> formDtoSetToEntities(final Set<UserDataDTO> userDTOSet) {
        Set<User> userSet = new HashSet<>();
        try {
            for (UserDataDTO source : userDTOSet) {
                User target = formDtoToEntity(source);
                userSet.add(target);
            }
            return userSet;
        } catch (NullPointerException ne) {
            return userSet;
        }
    }

    @Override
    public List<UserDataDTO> entitiesToDataDtoList(List<User> entityList) {
        List<UserDataDTO> DTOList = new ArrayList<>();
        for (User source : entityList) {
            UserDataDTO target = entityToDataDTO(source);
            DTOList.add(target);
        }
        return DTOList;
    }
}
