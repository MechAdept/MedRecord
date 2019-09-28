package com.samsolutions.converter;

import java.util.List;
import java.util.Set;

public interface DTOConverter<A, B, C> {

    B entityToDataDto(A source);

    A formDtoToEntity(C source);

    Set<B> entitiesToDataDtoSet(Set<A> sourceSet);

    List<B> entitiesToDataDtoList(List<A> sourceList);

    Set<A> formDtoSetToEntities(Set<C> sourceSet);
}
