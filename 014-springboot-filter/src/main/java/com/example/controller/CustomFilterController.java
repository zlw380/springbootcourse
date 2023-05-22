package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomFilterController {

    @RequestMapping("/user/account")
    @ResponseBody
    public String userAccount() {
        return "访问请求路径/user/account";
    }

    @RequestMapping("/query")
    @ResponseBody
    public String queryAccount() {
        return "访问请求路径/query";
    }
}
