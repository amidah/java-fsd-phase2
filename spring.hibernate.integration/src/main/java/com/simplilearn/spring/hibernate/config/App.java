package com.simplilearn.spring.hibernate.config;


import com.simplilearn.spring.hibernate.service.UserService;
import com.simplilearn.spring.hibernate.service.UserServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * Hello world!
 */
public class App {

  public static void main (String[] args) {

    AnnotationConfigApplicationContext
        annotationConfigApplicationContext
        = new AnnotationConfigApplicationContext(AppConfig.class);

    UserService userService = annotationConfigApplicationContext.getBean(
        "userServiceImpl",
        UserServiceImpl.class
    );

    userService.save();
  }
}
