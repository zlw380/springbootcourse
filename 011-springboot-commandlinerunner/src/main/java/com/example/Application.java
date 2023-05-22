package com.example;

import com.example.service.HelloService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
//实现CommandLineRunner接口，并实现接口中的run方法
//run方法会在主方法中的容器对象创建之后执行
public class Application implements CommandLineRunner {

    //byType自动注入，将容器中的对象给Application类中属性赋值
    //可以说Application类既有spring IOC xml配置文件的作用
    //创建spring容器读取配置文件(Application类自己)创建容器中对象
    //本身又是一个能够被自动注入的普通类(通过组件扫描器自己扫描自己)

    //不过Application类对象是最先被创建的，在调用run方法创建
    //容器对象时也会扫描加在自身属性上的注解并自动赋值
    @Resource
    private HelloService helloService;

    public static void main(String[] args) {
        System.out.println("准备创建容器对象");
        SpringApplication.run(Application.class, args);
        System.out.println("容器对象创建之后");

    }

    @Override
    public void run(String... args) throws Exception {
        //可以做自定义的操作，可以读取文件，数据库等等
        String str = helloService.sayHello("lisi");
        System.out.println("调用容器中的对象" + str);
        System.out.println("在容器对象创建好后，执行的方法");
    }
}

/*  执行顺序：
    1.准备创建容器对象
    2.调用容器中的对象hello!lisi
    3.在容器对象创建好后，执行的方法
    4.容器对象创建之后
    由此可见，在执行完主方法中的调用run方法创建容器语句后
    会立即执行CommandLineRunner接口的run方法
    执行完毕后再回到主方法执行下面的语句
    */
