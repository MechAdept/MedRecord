package com.samsolutions.controllers;

import com.samsolutions.entity.Users;
import com.samsolutions.impl.UsersServiceImpl;
import com.samsolutions.service.UsersDataService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;
import java.util.function.Supplier;

public class Main {

//    static final Logger rootLogger = LogManager.getRootLogger();
//    static final Logger userLogger = LogManager.getLogger(User.class);

    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring-config.xml"); //move from src.main.java to src.main.resources
        ctx.refresh();

        UsersDataService service = ctx.getBean("jpaUsersDataService", UsersDataService.class);
        List<Users> users = service.findAll();
        printAll(users);


        users = service.findById(2);
        printAll(users);

        users = service.findByLogin("USER1");
        printAll(users);



//        User user = new User();
//        user.setName("Anakin");
//        user.setLastName("Skywalker");
//
//        userLogger.info(user.showMeMessage());
//        userLogger.info(user.giveMeASign());
//
//        rootLogger.info("Root Logger: "  + user.showMeMessage());
//
//        Supplier<User> Debug = User::new;
//        Debug.get();
//        //debug
//        if (rootLogger.isDebugEnabled()) {
//            rootLogger.debug("RootLogger: In debug message");
//            userLogger.debug("UserLogger in debug");
//        }
//
//        try {
//            User userNull = new User();
//            userNull.getName().toString();
//        } catch (NullPointerException ex) {
//            userLogger.error("error message: " + ex.getMessage());
//            userLogger.fatal("fatal error message: " + ex.getMessage());
//            rootLogger.debug("RootLogger: In debug message");
//            userLogger.debug("UserLogger in debug");
//        }
//

    }
    private static void printAll(List<Users> users) {
        System.out.println("printAll: ");
        for (Users user : users) {
            System.out.println(user);
        }
    }
}