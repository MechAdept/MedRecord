package com.samsolutions.service.impl;

import com.google.common.collect.Lists;
import com.samsolutions.entity.User;
import com.samsolutions.repository.UserRepository;
import com.samsolutions.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("UserService")
//@Repository
public class UserServiceImpl implements UserService {

    final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

    //read
    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return Lists.newArrayList(userRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public void updateUser(User user) {userRepository.save(user);}

    //delete
    @Override
    @Transactional
    public void delete(Integer id) {
        userRepository.delete(id);
    }

    @Override
    public boolean exists(User user) {
        return userRepository.exists(user.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findById(Integer Id) {
        return userRepository.findById(Id);
    }

    //create
    @Override
    @Transactional
    public void createUser(User user) {userRepository.save(user);}

    @Override
    @Transactional(readOnly = true)
    public User findByLogin(String Login) {
        return userRepository.findByLogin(Login);
    }
}