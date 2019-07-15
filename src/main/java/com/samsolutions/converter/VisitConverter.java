package com.samsolutions.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsolutions.dto.VisitDTO;
import com.samsolutions.entity.Visit;
import org.springframework.beans.BeanUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class VisitConverter implements DTOConverter<Visit, VisitDTO> {

    @Override
    public VisitDTO EntityToDTO(Visit visit) {
        VisitDTO visitDTO = new VisitDTO();
        BeanUtils.copyProperties(visit, visitDTO);
        return visitDTO;
    }

    @Override
    public Visit DTOToEntity(VisitDTO visitDTO) {
        Visit visit = new Visit();
        BeanUtils.copyProperties(visitDTO, visit);
        return visit;
    }

    @Override
    public List<VisitDTO> EListToDTO(List<Visit> entityList) {
        List<VisitDTO> visitDTOList = new ArrayList<>();
        for (Visit source : entityList) {
            VisitDTO target = new VisitDTO();
            BeanUtils.copyProperties(source, target);
            visitDTOList.add(target);
        }
        return visitDTOList;
    }

    @Override
    public List<Visit> DTOListToEntity(List<VisitDTO> visitDTOList) {
        List<Visit> visitList = new ArrayList<>();
        for (VisitDTO source : visitDTOList) {
            Visit target = new Visit();
            BeanUtils.copyProperties(source, target);
            visitList.add(target);
        }
        return visitList;
    }

    @Override
    public String DTOToJSON(VisitDTO visitDTO) {
        String json = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            json = mapper.writeValueAsString(visitDTO);
        } catch (JsonProcessingException e) {
            System.out.println("Не удалось конвертировать в JSON"); //ДОБАВИТЬ ЛОГГЕР
        }
        return json;
    }

    @Override
    public VisitDTO JSONToDTO(String json) {
        ObjectMapper mapper = new ObjectMapper();
        VisitDTO visitDTO = null;
        try {
            visitDTO = mapper.readValue(json, VisitDTO.class);
        } catch (IOException e) {
            System.out.println("Не удалось конвертировать в DTO"); //ДОБАВИТЬ ЛОГГЕР
        }
        return visitDTO;
    }
}

