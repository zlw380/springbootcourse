package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*直接扫描以下包中的所有Dao接口和Mapper文件
  并创建代理对象注入spring容器
  basePackages:Dao接口所在的包名*/
@MapperScan(basePackages = {"com.example.dao", "com.example.mapper"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("执行springboot-mapperscan启动类");
    }

}
