package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloSpringBoot {

    @GetMapping("/hello")
    @ResponseBody
    public String helloSpringBoot() {
        return "欢迎您使用springboot!";
    }

    @GetMapping("/hi")
    @ResponseBody
    public String hiSpringBoot() {
        return "/src/main/resources/templates/hello.html";
    }

    @GetMapping("/retry")
    @ResponseBody
    public String retrySpringBoot() {
        return "005test";
    }
}
