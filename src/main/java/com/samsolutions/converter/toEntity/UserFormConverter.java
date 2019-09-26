package com.samsolutions.converter.toEntity;

import com.samsolutions.dto.form.UserFormDTO;
import com.samsolutions.entity.User;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UserFormConverter implements FormDTOConverter<User, UserFormDTO> {

    @Override
    public User formDtoToEntity(UserFormDTO formDto) {
        return null;
    }

    @Override
    public Set<User> formDtoSetToEntities(Set<UserFormDTO> formDtoSet) {
        return null;
    }
}
