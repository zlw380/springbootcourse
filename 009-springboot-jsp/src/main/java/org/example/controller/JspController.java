package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class JspController {

/*    @RequestMapping("/myjsp")
    public String doJsp(HttpServletRequest request){
        request.setAttribute("data","小狐狸学java");
        return "index";
    }*/

    @RequestMapping("/myjsp")
    public String doJsp(Model model) {
        //数据放入request作用域
        model.addAttribute("data", "小狐狸学java");
        return "index";
    }
}
