package com.samsolutions.repository;

import com.samsolutions.entity.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersRepository extends CrudRepository<Users, Integer> {
    List<Users> findById(int id);
    List<Users> findByLogin(String login);
}
