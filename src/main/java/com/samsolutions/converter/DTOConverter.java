package com.samsolutions.converter;

import java.util.List;

public interface DTOConverter<A, B> {
    B EntityToDTO(A entity);

    A DTOToEntity(B dto);

    List<B> EListToDTO(List<A> entityList);

    List<A> DTOListToEntity(List<B> dtoList);

    String DTOToJSON(B dto);

    B JSONToDTO(String json);
}