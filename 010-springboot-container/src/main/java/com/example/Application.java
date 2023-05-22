package com.example;

import com.example.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //获取容器对象,用它的父类接口接收返回值也可以
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

        UserService userService = (UserService) ctx.getBean("userService");

        userService.sayHello("李四");
    }

}
