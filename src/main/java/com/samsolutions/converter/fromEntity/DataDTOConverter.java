package com.samsolutions.converter.fromEntity;

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

public interface DataDTOConverter<A, B> {

    /**
     * Method to convert entity to DTO.
     *
     * @param entity is entity.
     * @return corresponding DTO.
     */
    B entityToDataDTO(A entity);


    /**
     * Method to convert list of DTOs to list of entities.
     *
     * @param entitySet is entityList.
     * @return corresponding list of DTOs.
     */
    Set<B> entitiesToDataDtoSet(Set<A> entitySet);

    List<B> entitiesToDataDtoList(List<A> entityList);
}