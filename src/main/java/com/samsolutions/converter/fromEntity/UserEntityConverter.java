package com.samsolutions.converter.fromEntity;

import com.samsolutions.dto.data.UserDataDTO;
import com.samsolutions.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class UserEntityConverter implements DataDTOConverter<User, UserDataDTO>{

    @Override
    public UserDataDTO entityToDataDTO(User entity) {
        return null;
    }

    @Override
    public Set<UserDataDTO> entitiesToDataDtoSet(Set<User> entitySet) {
        return null;
    }

    @Override
    public List<UserDataDTO> entitiesToDataDtoList(List<User> entityList) {
        return null;
    }
}
