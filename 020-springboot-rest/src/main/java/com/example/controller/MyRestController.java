package com.example.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class MyRestController {

    //学习Restful注解的使用
    //查询id为1001的学生
    /*@PathVariable（路径变量）:
     * 作用是获取url中的数据
     * 属性：value 定义路径变量的
     * 位置：放在控制器方法形参的前面
     *
     * http://localhost:8080/myboot/student/1001
     * 传入的参数在访问请求url中使用占位符表示
     * @PathVariable中设置的值与定义路径变量名称相同
     * 这样就能把url中的参数匹配传入到控制器方法当中
     *
     * {id}：定义路径变量 id是自定义的名称*/
    @GetMapping("student/{id}")
    public String queryStudent(@PathVariable(value = "id") Integer id) {
        return "查询学生studentId=" + id;
    }

    /*创建资源 Post请求方式
     * http://localhost:8080/myboot/student/name/201*/
    @PostMapping("/student/{name}/{age}")
    public String createStudent(@PathVariable("name") String name,
                                @PathVariable("age") Integer age) {
        return "创建的学生name=" + name + " age=" + age;
    }

    /*更新资源
     * 当路径变量名称和形参名一样，@PathVariable中的value可以省略*/
    @PutMapping("/student/{id}/{age}")
    public String modifyStudent(@PathVariable Integer id,
                                @PathVariable Integer age) {
        return "更新资源，使用put方式，将id为" + id + "的学生年龄修改为" + age;
    }

    /*删除资源*/
    @DeleteMapping("/student/{id}")
    public String removeStudentById(@PathVariable Integer id) {
        return "删除资源，删除id为" + id + "的学生";
    }

    @PostMapping("/student/test")
    public String test() {
        return "执行student/test,使用的请求方式post";
    }

    @PostMapping("/student/1")
    public String testInteger() {
        return "执行student/1,使用的请求方式post";
    }

    @PutMapping("/student/test")
    public String testPut() {
        return "执行student/test,使用的请求方式put";
    }

    @DeleteMapping("/student/test")
    public String testDelete() {
        return "执行student/test,使用的请求方式delete";
    }
}

/*Restful风格
 * 相当于通过三个变量确定前端请求所对应的控制器方法
 * 1.请求方式：确定了使用get/post/put/delete中的哪一项操作，对应了查询、添加、修改、删除
 * 2.请求的url地址中的资源：确定了要对哪一种资源进行操作（student）
 * 3.请求的url地址中的参数：确定要对资源的哪一个对象进行操作（marisa）
 * 这三个变量的不同组合就可以代表各种不同的请求
 * 只要这三个变量不同时相等就不会出现请求冲突*/
