package com.samsolutions.converter;

import java.util.List;

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
     * @param entityList is entityList.
     * @return corresponding list of DTOs.
     */
    List<B> entitiesToDtoList(List<A> entityList);

    /**
     * Method to convert list of DTOs to list of entities.
     *
     * @param dtoList is dtoList.
     * @return corresponding list of entities.
     */
    List<A> dtoListToEntities(List<B> dtoList);

//    String DTOToJSON(B dto); //TODO: Do I need these methods?
//
//    B JSONToDTO(String json);//TODO: Do I need these methods?
}