package com.samsolutions.service.impl;

import com.google.common.collect.Lists;
import com.samsolutions.entity.UserEntity;
import com.samsolutions.repository.UserRepository;
import com.samsolutions.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service("UserService")
@Repository
@Transactional
public class UserServiceImpl implements UserService {
    final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<UserEntity>findAll(){
        return Lists.newArrayList(userRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserEntity>findById(Integer Id){
        return userRepository.findById(Id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserEntity>findByLogin(String Login){
        return userRepository.findByLogin(Login);
    }
}