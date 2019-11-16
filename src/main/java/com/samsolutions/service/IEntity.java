package com.samsolutions.service;

import org.springframework.stereotype.Service;

@Service
public interface IEntity<DataDTO, FormDTO> {

    /**
     * Method for find "A" by id.
     *
     * @param id id of desired "A".
     * @return "A".
     */
    DataDTO findById(Long id);

    /**
     * Method for delete Entity by id.
     *
     * @param id id of desired Entity.
     */
    void delete(Long id);

    /**
     * Method for create health.
     *
     * @param form formDataDTO with parameters to be set.
     */
    void save(FormDTO form);
}
