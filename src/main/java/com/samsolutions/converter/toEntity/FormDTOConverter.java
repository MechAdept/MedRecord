package com.samsolutions.converter.toEntity;

import java.util.Set;

public interface FormDTOConverter<A, B> {

    A formDtoToEntity(B formDto);

    Set<A> formDtoSetToEntities(Set<B> formDtoSet);
}
