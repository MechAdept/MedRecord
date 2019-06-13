package com.samsolutions.repository;

import com.samsolutions.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findById(int id);

    List<User> findByLogin(String login);
}
