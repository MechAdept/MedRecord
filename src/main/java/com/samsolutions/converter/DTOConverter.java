package com.samsolutions.converter;

import java.util.List;

public interface DTOConverter<A, B, C> {

    B entityToDataDto(A source);

    A formDtoToEntity(C source);

    List<B> entitiesToDataDtoList(List<A> sourceList);
}
