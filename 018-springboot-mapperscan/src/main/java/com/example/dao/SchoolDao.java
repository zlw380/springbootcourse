package com.example.dao;

import com.example.model.Student;
import org.apache.ibatis.annotations.Param;

public interface SchoolDao {
    Student selectById(@Param("stuId") Integer id);
}
