//package com.samsolutions.service.impl;
//import com.samsolutions.entity.User;
//import com.samsolutions.repository.UserRepository;
//import com.samsolutions.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//import java.util.Optional;
//
//@Service("UserService")
//public class UserServiceImpl implements UserService {
//
////    final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
////
////    @Autowired
////    private UserDAO userDAO;
////
////    @Override
////    public List<User> getAllData() {
////        List<User> result = userDAO.getAllUsers();
////        return result;
////    }
//
//    @Autowired
//    @Qualifier("userRepository")
//    private UserRepository userRepository;
//
//    @Override
//    public Optional<User> findById(Integer id) {
//        Optional<User> result = userRepository.findById(id);
//        return result;
//    }
//}