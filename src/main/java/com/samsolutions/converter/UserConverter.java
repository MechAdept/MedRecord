package com.samsolutions.converter;

import com.samsolutions.dto.data.UserDataDTO;
import com.samsolutions.dto.form.UserFormDTO;
import com.samsolutions.entity.User;
import com.samsolutions.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class UserConverter implements DTOConverter<User, UserDataDTO, UserFormDTO> {

    @Autowired
    RoleConverter roleConverter;

    @Autowired
    RoleService roleService;

    @Override
    public UserDataDTO entityToDataDto(User source) {
        UserDataDTO target = new UserDataDTO();
        target.setId(source.getId());
        target.setUsername(source.getUsername());
        target.setPassword(source.getPassword());
        target.setName(source.getName());
        target.setSurname(source.getSurname());
        target.setPatronymic(source.getPatronymic());
        target.setTelephone(source.getTelephone());
        target.setBirth(source.getBirth());
        target.setSex(source.getSex());
        target.setImg(source.getImg());
        try {
            target.setRoles(roleConverter.entitiesToDataDtoSet(source.getRoles()));
            return target;
        } catch (NullPointerException ne) {
            return target;
        }
    }

    @Override
    public User formDtoToEntity(UserFormDTO source) {
        User target = new User();
        target.setId(source.getId());
        target.setUsername(source.getUsername());
        target.setPassword(source.getPassword());
        target.setName(source.getName());
        target.setSurname(source.getSurname());
        target.setPatronymic(source.getPatronymic());
        target.setTelephone(source.getTelephone());
        target.setBirth(LocalDateTime.parse(source.getBirth(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        target.setSex(source.getSex());
        target.setImg(source.getImg());
        target.setRoles(roleService.findRolesById(source.getRolesId()));
        return target;
    }

    @Override
    public Set<UserDataDTO> entitiesToDataDtoSet(Set<User> sourceSet) {
        Set<UserDataDTO> targetSet = new HashSet<>();
        try {
            for (User source : sourceSet) {
                UserDataDTO target = entityToDataDto(source);
                targetSet.add(target);
            }
            return targetSet;
        } catch (NullPointerException ne) {
            return targetSet;
        }
    }

    @Override
    public List<UserDataDTO> entitiesToDataDtoList(List<User> sourceList) {
        List<UserDataDTO> targetList = new ArrayList<>();
        try {
            for (User source : sourceList) {
                UserDataDTO target = entityToDataDto(source);
                targetList.add(target);
            }
            return targetList;
        } catch (NullPointerException ne) {
            return targetList;
        }
    }

    @Override
    public Set<User> formDtoSetToEntities(Set<UserFormDTO> sourceSet) {
        Set<User> targetSet = new HashSet<>();
        try {
            for (UserFormDTO source : sourceSet) {
                User target = formDtoToEntity(source);
                targetSet.add(target);
            }
            return targetSet;
        } catch (NullPointerException ne) {
            return targetSet;
        }
    }
}
