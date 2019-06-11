package com.samsolutions.repository;

import com.samsolutions.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findById(Integer id);
//    List<User> findByLogin(String login);
//
//    @Query("select b from User b")
//    List<User> getAllById(@Param("Id") Integer Id);
}