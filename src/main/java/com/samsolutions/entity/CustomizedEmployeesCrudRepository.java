package com.samsolutions.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomizedEmployeesCrudRepository extends CrudRepository<Employees,Long> {
}
