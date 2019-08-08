package com.samsolutions.converter;

import java.util.List;
import java.util.Set;

/**
 * Interface for converting operations.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.converter
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

public interface DTOConverter<A, B> {

    /**
     * Method to convert entity to DTO.
     *
     * @param entity is entity.
     * @return corresponding DTO.
     */
    B entityToDTO(A entity);

    /**
     * Method to convert DTO to entity.
     *
     * @param dto is DTO.
     * @return corresponding entity.
     */
    A dtoToEntity(B dto);

    /**
     * Method to convert list of DTOs to list of entities.
     *
     * @param entitySet is entityList.
     * @return corresponding list of DTOs.
     */
    Set<B> entitiesToDtoSet(Set<A> entitySet);

    /**
     * Method to convert list of DTOs to list of entities.
     *
     * @param dtoSet is dtoList.
     * @return corresponding list of entities.
     */
    Set<A> dtoSetToEntities(Set<B> dtoSet);

    List<B> entitiesToDtoList(List<A> entityList);
}