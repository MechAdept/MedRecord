package com.samsolutions.service;
//import com.samsolutions.dao.UserDAO;

import com.samsolutions.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    Optional<User> findById(Integer id);

}