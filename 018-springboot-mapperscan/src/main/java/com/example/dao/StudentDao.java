package com.example.dao;

import com.example.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/*@Mapper注解
  告诉MyBatis这是Dao接口，创建此接口的代理对象
  (动态代理自动创建实现类对象)
  不再像spring框架一样在xml配置文件中声明dao对象
  位置：在Dao接口的上面*/

public interface StudentDao {
    //使用@Param传参，将传入的参数id的参数名自定义为stuId
    //与mapper文件中的#{stuId}相匹配
    Student selectById(@Param("stuId") Integer id);
}

/*Dao接口的代理对象也是利用Java的JDK动态代理实现的
 * 代理对象中，sqlSession会话对象及其对数据库执行CRUD操作的方法
 * 分别对应目标对象和目标方法
 * Mybatis动态代理会根据Dao接口中的方法名找到mapper映射文件中对应的SQL语句
 * 然后把这个SQL语句作为参数传入目标方法当中,执行CRUD操作*/
