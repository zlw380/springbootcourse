package com.example.controller;

import com.example.model.Student;
import com.example.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class StudentController {
    @Resource
    private StudentService studentService;

    @RequestMapping("/addStudent")
    @ResponseBody
    public String addStudent(Student student) {
        int insert = studentService.addStudent(student);
        if (insert > 0) {
            return "添加学生成功！添加的记录条数：" + insert;
        } else {
            return "添加失败！";
        }
    }
}
