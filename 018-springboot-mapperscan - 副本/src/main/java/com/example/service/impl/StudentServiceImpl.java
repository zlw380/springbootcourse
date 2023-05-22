package com.example.service.impl;

import com.example.dao.StudentDao;
import com.example.model.Student;
import com.example.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    @Override
    public Student queryStudent(Integer id) {
        System.out.println("执行根据id查询学生方法");
        Student student = studentDao.selectById(id);
        return student;
    }
}
