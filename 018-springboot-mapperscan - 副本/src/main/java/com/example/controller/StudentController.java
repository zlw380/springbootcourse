package com.example.controller;

import com.example.model.Student;
import com.example.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class StudentController {
    @Resource
    private StudentService studentService;

    @RequestMapping("/queryStudent")
    @ResponseBody
    public String queryStudent(Integer id) {

        Student student = studentService.queryStudent(id);

        return student.toString();
    }
}
