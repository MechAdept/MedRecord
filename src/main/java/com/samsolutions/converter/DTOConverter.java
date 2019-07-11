package com.samsolutions.converter;

import java.util.List;

public interface DTOConverter<A,B> {
    public B EntityToDTO(A entity);
    public A DTOToEntity(B dto);
    public List<B> EListToDTO(List<A> entityList);
    public List<A> DTOListToEntity(List<B> dtoList);
    public String DTOToJSON(B dto);
    public B JSONToDTO (String json);
}