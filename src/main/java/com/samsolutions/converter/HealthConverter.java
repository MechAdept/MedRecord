package com.samsolutions.converter;

import com.samsolutions.dto.HealthDTO;
import com.samsolutions.dto.UserDTO;
import com.samsolutions.entity.Health;
import com.samsolutions.entity.User;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Converter for Health.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.converter
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

public class HealthConverter implements DTOConverter<Health, HealthDTO> {
    private DTOConverter<User, UserDTO> userConverter = new UserConverter();

    @Override
    public HealthDTO entityToDTO(final Health health) {
        HealthDTO healthDTO = new HealthDTO();
        BeanUtils.copyProperties(health, healthDTO);
        return healthDTO;
    }

    @Override
    public Health dtoToEntity(final HealthDTO healthDTO) {
        Health health = new Health();
        BeanUtils.copyProperties(healthDTO, health);
        return health;
    }

    @Override
    public List<HealthDTO> entitiesToDtoList(final List<Health> entityList) {
        List<HealthDTO> healthDTOList = new ArrayList<>();
        for (Health source : entityList) {
            HealthDTO target = new HealthDTO();
            BeanUtils.copyProperties(source, target);
            target.setPatient(userConverter.entityToDTO(source.getPatient()));
            healthDTOList.add(target);
        }
        return healthDTOList;
    }

    @Override
    public List<Health> dtoListToEntities(final List<HealthDTO> healthDTOList) {
        List<Health> healthList = new ArrayList<>();
        for (HealthDTO source : healthDTOList) {
            Health target = new Health();
            BeanUtils.copyProperties(source, target);
            healthList.add(target);
        }
        return healthList;
    }

//    @Override
//    public String DTOToJSON(HealthDTO healthDTO) {
//        String json = "";
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            json = mapper.writeValueAsString(healthDTO);
//        } catch (JsonProcessingException e) {
//            System.out.println("Не удалось конвертировать в JSON"); //TODO: Add logger
//        }
//        return json;
//    }
//
//    @Override
//    public HealthDTO JSONToDTO(String json) {
//        ObjectMapper mapper = new ObjectMapper();
//        HealthDTO healthDTO = null;
//        try {
//            healthDTO = mapper.readValue(json, HealthDTO.class);
//        } catch (IOException e) {
//            System.out.println("Не удалось конвертировать в DTO"); //TODO: Add logger
//        }
//        return healthDTO;
//    }


    /**
     * Returns userConverter.
     *
     * @return userConverter.
     */
    public DTOConverter<User, UserDTO> getUserConverter() {
        return userConverter;
    }

    /**
     * Sets userConverter.
     *
     * @param userConverter converter to be set.
     */
    public void setUserConverter(final DTOConverter<User, UserDTO> userConverter) {
        this.userConverter = userConverter;
    }
}
