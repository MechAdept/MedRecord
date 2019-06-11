//package com.samsolutions.dao;
//
//import com.samsolutions.entity.User;
//import org.springframework.stereotype.Repository;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import java.util.List;
//
//@Repository
//public class UserDAO {
//    @PersistenceContext
//    private EntityManager entityManager;
//    @SuppressWarnings("unchecked")
//    public List<User> getAllUsers() {
//        List<?> list = entityManager.createQuery("SELECT p FROM User p").getResultList();
//        return (List<User>) list;
//    }
//}