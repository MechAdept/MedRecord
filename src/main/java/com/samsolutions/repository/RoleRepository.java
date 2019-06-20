package com.samsolutions.repository;

import com.samsolutions.entity.Role;
import com.samsolutions.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role findRoleById(Integer id);
}
