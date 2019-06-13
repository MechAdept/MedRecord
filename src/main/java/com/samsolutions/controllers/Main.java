package com.samsolutions.controllers;

import com.samsolutions.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.samsolutions.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:/application-context.xml");

        UserService service = ctx.getBean("UserService", UserService.class);
        List<User> users = service.findAll();
        printAll(users);

        users = service.findById(2);
        printAll(users);

        users = service.findByLogin("USER1");
        printAll(users);
    }
    private static void printAll(List<User> users) {
        System.out.println("printAll: ");
        System.out.println("printAll: ");
        System.out.println("printAll: ");
        System.out.println("printAll: ");
        System.out.println("printAll: ");
        System.out.println("printAll: ");
        System.out.println("printAll: ");
        System.out.println("printAll: ");
        System.out.println("printAll: ");

        for (User user : users) {
            System.out.println(user.getType());
        }
    }
}
