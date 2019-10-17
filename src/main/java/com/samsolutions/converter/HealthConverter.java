package com.samsolutions.converter;

import com.samsolutions.dto.data.HealthDataDTO;
import com.samsolutions.dto.form.HealthFormDTO;
import com.samsolutions.entity.Health;
import com.samsolutions.repository.HealthRepository;
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

    @Autowired
    HealthRepository healthRepository;

    @Override
    public HealthDataDTO entityToDataDto(final Health source) {
        HealthDataDTO target = new HealthDataDTO();
        target.setId(source.getId());
        target.setPatient(userConverter.entityToDataDto(source.getPatient()));
        target.setHeight(source.getHeight());
        target.setWeight(source.getWeight());
        target.setChest(source.getChest());
        target.setWaist(source.getWaist());
        target.setHips(source.getHips());
        target.setNervous(source.getNervous());
        target.setConstitution(source.getConstitution());
        target.setMusculature(source.getMusculature());
        target.setLeye(source.getLeye());
        target.setReye(source.getReye());
        target.setBlood(source.getBlood());
        target.setAlcohol(source.getAlcohol());
        target.setSmoke(source.getSmoke());
        target.setDrugs(source.getDrugs());
        try {
            target.setPatient(userConverter.entityToDataDto(source.getPatient()));
            return target;
        } catch (Exception ne) {
            return target;
        }
    }

    @Override
    public Health formDtoToEntity(final HealthFormDTO source) {
        Health target = new Health();
        target.setId(source.getId());
        target.setHeight(Long.parseLong(source.getHeight()));
        target.setWeight(Long.parseLong(source.getWeight()));
        target.setChest(Long.parseLong(source.getChest()));
        target.setWaist(Long.parseLong(source.getWaist()));
        target.setHips(Long.parseLong(source.getHips()));
        target.setNervous(source.getNervous());
        target.setConstitution(source.getConstitution());
        target.setMusculature(source.getMusculature());
        target.setLeye(Float.valueOf(source.getLeye()));
        target.setReye(Float.valueOf(source.getReye()));
        target.setBlood(source.getBlood());
        target.setAlcohol(source.getAlcohol());
        target.setSmoke(source.getSmoke());
        target.setDrugs(source.getDrugs());
        try {
            target.setPatient(userRepository.getOne(source.getPatientId()));
            return target;
        } catch (Exception e) {
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
