package com.samsolutions.impl;

import com.google.common.collect.Lists;
import com.samsolutions.entity.Users;
import com.samsolutions.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Repository
@Transactional
public class UsersServiceImpl {
    @Autowired
    private UsersRepository usersRepository;

    public List<Users>findAll(){
        return Lists.newArrayList(usersRepository.findAll());
    }

    public List<Users>findById(Integer Id){
        return usersRepository.findById(Id);
    }

    public List<Users>findByLogin(String Login){
        return usersRepository.findByLogin(Login);
    }
}
