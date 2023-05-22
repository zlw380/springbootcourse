package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BootController {

    @RequestMapping("/hello")
    @ResponseBody
    public String doSome() {
        return "hello Springboot应用,设置了端口号!";
    }
}
