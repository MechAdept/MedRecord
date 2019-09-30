package com.samsolutions.converter;

import com.samsolutions.dto.data.HealthDataDTO;
import com.samsolutions.dto.form.HealthFormDTO;
import com.samsolutions.entity.Health;
import com.samsolutions.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class HealthConverter implements DTOConverter<Health, HealthDataDTO, HealthFormDTO> {

    @Autowired
    UserConverter userConverter;

    @Autowired
    UserRepository userRepository;

    @Override
    public HealthDataDTO entityToDataDto(final Health source) {
        HealthDataDTO target = new HealthDataDTO();
        BeanUtils.copyProperties(source, target);
        try {
            target.setPatient(userConverter.entityToDataDto(source.getPatient()));
            return target;
        } catch (NullPointerException ne) {
            return target;
        }
    }

    @Override
    public Health formDtoToEntity(final HealthFormDTO source) {
        Health target = new Health();
        BeanUtils.copyProperties(source, target);
        try {
            target.setPatient(userRepository.getOne(source.getId()));
            return target;
        } catch (NullPointerException ne) {
            return target;
        }
    }

    @Override
    public List<HealthDataDTO> entitiesToDataDtoList(List<Health> entityList) {
        List<HealthDataDTO> DTOList = new ArrayList<>();
        for (Health source : entityList) {
            HealthDataDTO target = entityToDataDto(source);
            DTOList.add(target);
        }
        return DTOList;
    }
}
