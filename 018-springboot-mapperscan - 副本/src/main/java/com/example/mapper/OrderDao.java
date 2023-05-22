package com.example.mapper;

import com.example.model.Student;
import org.apache.ibatis.annotations.Param;

public interface OrderDao {
    Student selectById(@Param("stuId") Integer id);
}
