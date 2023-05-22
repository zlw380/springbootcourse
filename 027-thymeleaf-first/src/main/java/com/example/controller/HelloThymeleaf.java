package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloThymeleaf {
    @GetMapping("/hello")
    public String HelloThymeleaf(Model model, HttpServletRequest request) {
        //添加数据到request作用域，模板引擎可以从request中获取数据
        request.setAttribute("data", "欢迎使用Thymeleaf模板引擎!");
        model.addAttribute("mydata", "model中的数据");
        //指定视图（模板引擎使用的页面：html）
        //视图的逻辑名称
        return "hello";
    }
}
