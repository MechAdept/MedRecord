package com.samsolutions.dao;

import com.samsolutions.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDao {
    private final SessionFactory sessionFactory;
    @Autowired
    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

//    public void createUser(User user) {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        session.save(user);
//        session.getTransaction().commit();
//        session.close();
//    }
    
//    public List<User> getUserList() {
//        Session session = sessionFactory.openSession();
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<User> cq = cb.createQuery(User.class);
//        Root<User> root = cq.from(User.class);
//        Query query = session.createQuery(cq);
//        List<User> userList = query.getResultList();
//        session.close();
//        return userList;
//    }
}