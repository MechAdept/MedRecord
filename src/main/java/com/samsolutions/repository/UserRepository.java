package com.samsolutions.repository;

import com.samsolutions.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface    UserRepository extends CrudRepository<UserEntity, Integer> {
    List<UserEntity> findAll();
    List<UserEntity> findById(int id);
    List<UserEntity> findByLogin(String login);
}
