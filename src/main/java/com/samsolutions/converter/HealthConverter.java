package com.samsolutions.converter;

import com.samsolutions.dto.HealthDTO;
import com.samsolutions.entity.Health;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Converter for Health.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.converter
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Component
public class HealthConverter implements DTOConverter<Health, HealthDTO> {

    @Autowired
    private UserConverter userConverter;

    @Override
    public HealthDTO entityToDTO(final Health source) {
        HealthDTO target = new HealthDTO();
        target.setId(source.getId());
        target.setPatient(userConverter.entityToDTO(source.getPatient()));
        target.setBirth(source.getBirth());
        target.setPhoto(source.getPhoto());
        return target;
    }

    @Override
    public Health dtoToEntity(final HealthDTO source) {
        Health target = new Health();
        target.setId(source.getId());
        target.setPatient(userConverter.dtoToEntity(source.getPatient()));
        target.setBirth(source.getBirth());
        target.setPhoto(source.getPhoto());
        return target;
    }

    @Override
    public Set<HealthDTO> entitiesToDtoSet(final Set<Health> entitySet) {
        Set<HealthDTO> healthDTOSet = new HashSet<>();
        for (Health source : entitySet) {
            HealthDTO target = entityToDTO(source);
            healthDTOSet.add(target);
        }
        return healthDTOSet;
    }

    @Override
    public Set<Health> dtoSetToEntities(final Set<HealthDTO> healthDTOSet) {
        Set<Health> healthSet = new HashSet<>();
        for (HealthDTO source : healthDTOSet) {
            Health target = dtoToEntity(source);
            healthSet.add(target);
        }
        return healthSet;
    }

    @Override
    public List<HealthDTO> entitiesToDtoList(List<Health> entityList) {
        List<HealthDTO> DTOList = new ArrayList<>();
        for (Health source : entityList) {
            HealthDTO target = entityToDTO(source);
            DTOList.add(target);
        }
        return DTOList;
    }
}
