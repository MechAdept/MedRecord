package com.samsolutions.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsolutions.dto.HealthDTO;
import com.samsolutions.entity.Health;
import org.springframework.beans.BeanUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HealthConverter implements DTOConverter<Health, HealthDTO> {

    @Override
    public HealthDTO EntityToDTO(Health health) {
        HealthDTO healthDTO = new HealthDTO();
        BeanUtils.copyProperties(health, healthDTO);
        return healthDTO;
    }

    @Override
    public Health DTOToEntity(HealthDTO healthDTO) {
        Health health = new Health();
        BeanUtils.copyProperties(healthDTO, health);
        return health;
    }

    @Override
    public List<HealthDTO> EListToDTO(List<Health> entityList) {
        List<HealthDTO> healthDTOList = new ArrayList<>();
        for (Health source : entityList) {
            HealthDTO target = new HealthDTO();
            BeanUtils.copyProperties(source, target);
            healthDTOList.add(target);
        }
        return healthDTOList;
    }

    @Override
    public List<Health> DTOListToEntity(List<HealthDTO> healthDTOList) {
        List<Health> healthList = new ArrayList<>();
        for (HealthDTO source : healthDTOList) {
            Health target = new Health();
            BeanUtils.copyProperties(source, target);
            healthList.add(target);
        }
        return healthList;
    }

    @Override
    public String DTOToJSON(HealthDTO healthDTO) {
        String json = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            json = mapper.writeValueAsString(healthDTO);
        } catch (JsonProcessingException e) {
            System.out.println("Не удалось конвертировать в JSON"); //ДОБАВИТЬ ЛОГГЕР
        }
        return json;
    }

    @Override
    public HealthDTO JSONToDTO(String json) {
        ObjectMapper mapper = new ObjectMapper();
        HealthDTO healthDTO = null;
        try {
            healthDTO = mapper.readValue(json, HealthDTO.class);
        } catch (IOException e) {
            System.out.println("Не удалось конвертировать в DTO"); //ДОБАВИТЬ ЛОГГЕР
        }
        return healthDTO;
    }
}
