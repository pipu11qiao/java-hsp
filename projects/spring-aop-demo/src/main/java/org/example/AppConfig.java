package org.example;

import org.example.service.User;
import org.springframework.context.ApplicationContext;

import org.example.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class AppConfig {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
//        UserService userService = context.getBean(UserService.class);
//        User user = userService.login("bob@example.com", "password");
//        System.out.println(user.getName());
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        User user = userService.login("bob@example.com","password");
        System.out.println(userService.getClass().getName());
    }
}

