package com.samsolutions.converter;

import com.samsolutions.dto.data.UserDataDTO;
import com.samsolutions.dto.form.UserFormDTO;
import com.samsolutions.entity.User;
import com.samsolutions.service.RoleService;
import org.hibernate.LazyInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
        target.setBirth(Date.valueOf(source.getBirth()));
        target.setSex(source.getSex());
        target.setImg(source.getImg());
        try {
            target.setRoles(roleConverter.entitiesToDataDtoList(source.getRoles()));
            return target;
        } catch (LazyInitializationException le) {
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
        target.setSex(source.getSex());
        target.setRoles(roleService.findByIds(source.getRolesId()));
        try {
            target.setBirth(LocalDate.parse(source.getBirth(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        } catch (NullPointerException ne) {
            return target;
        }
        return target;
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
        } catch (LazyInitializationException le) {
            return targetList;
        }
    }
}
