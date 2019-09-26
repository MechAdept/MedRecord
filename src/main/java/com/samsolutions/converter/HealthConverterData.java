package com.samsolutions.converter;

import com.samsolutions.converter.fromEntity.DataDTOConverter;
import com.samsolutions.dto.data.HealthDataDTO;
import com.samsolutions.dto.form.HealthFormDTO;
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
public class HealthConverterData implements DataDTOConverter<Health, HealthDataDTO> {

    @Autowired
    private UserConverterData userConverter;

    @Override
    public HealthDataDTO entityToDataDTO(final Health source) {
        HealthDataDTO target = new HealthDataDTO();
        target.setId(source.getId());
        target.setPatient(userConverter.entityToDataDTO(source.getPatient()));
        target.setBirth(source.get());
        target.setPhoto(source.getPhoto());
        return target;
    }

    @Override
    public Health formDtoToEntity(final HealthFormDTO source) {
        Health target = new Health();

        target.setId(source.getId());
        target.setPatient(source.getPatient());


        target.setId(source.getId());
        target.setPatient(userConverter.formDtoToEntity(source.getPatient()));
        target.setBirth(source.getBirth());
        target.setPhoto(source.getPhoto());
        return target;
    }

    @Override
    public Set<HealthDataDTO> entitiesToDataDtoSet(final Set<Health> entitySet) {
        Set<HealthDataDTO> HealthDataDTOSet = new HashSet<>();
        for (Health source : entitySet) {
            HealthDataDTO target = entityToDataDTO(source);
            HealthDataDTOSet.add(target);
        }
        return HealthDataDTOSet;
    }

    @Override
    public Set<Health> formDtoSetToEntities(final Set<HealthDataDTO> HealthFormDTOSet) {
        Set<Health> healthSet = new HashSet<>();
        for (HealthDataDTO source : HealthDataDTOSet) {
            Health target = formDtoToEntity(source);
            healthSet.add(target);
        }
        return healthSet;
    }

    @Override
    public List<HealthDataDTO> entitiesToDataDtoList(List<Health> entityList) {
        List<HealthDataDTO> DTOList = new ArrayList<>();
        for (Health source : entityList) {
            HealthDataDTO target = entityToDataDTO(source);
            DTOList.add(target);
        }
        return DTOList;
    }
}
