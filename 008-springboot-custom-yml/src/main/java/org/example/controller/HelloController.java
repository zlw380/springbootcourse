package org.example.controller;

import org.example.vo.SchoolInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class HelloController {

    //@value注解给springMVC容器内控制类对象的属性赋值
    //值是从application.yml外部配置文件中获取的
    //获取的方式应该是Application类加的某个注解，作用等同于spring配置文件中的标签：
    //<context:property-placeholder location="classpath:jdbc.properties"/>

    //创建中央调度器对象(中央调度器随后创建springmvc容器对象，并读取配置文件创建控制器对象)
    //与声明springmvc容器对象中控制器对象及其属性值的操作由Application类完成
    //Application类中包含组件扫描器(@ComponentScan)
    //能够扫描controller包中的控制器类并在配置文件(就是Application类)中声明

    @Value("${server.port}")
    private Integer port;
    @Value("${server.servlet.context-path}")
    private String contextPath;
    @Value("${school.name}")
    private String name;
    @Value("${school.website}")
    private String site;
    @Value("${school.address}")
    private String address;

    //从容器中拿到一个SchoolInfo类型的对象赋给info
    @Resource
    private SchoolInfo info;

    @RequestMapping("/data")
    @ResponseBody
    public String queryData() {
        return " 端口" + port + " 路径" + contextPath + " 学校" + name + " 学校网站" + site + " 学校地址" + address;
    }

    @RequestMapping("/info")
    @ResponseBody
    public String queryInfo() {
        return "SchoolInfo对象==" + info;
    }

}

/*springmvc容器对象在被中央调度器创建之后也会被放入servletContext全局作用域当中
* 因为它也和spring容器对象一样，需要被经常调用其中的方法getBean获取service业务对象/controller控制器对象
* 所以在应用开启时创建一个容器对象以被不同的请求调用，直到应用关闭为止
* 在SSM框架/Springboot中，这些调用都是自动进行的：
*
* @Resource
  private StudentService service;
* SSM框架中，springmvc配置文件继承了spring配置文件中声明的标签
* 如<context:component-scan base-package="org.example.service"/>
* 因此可以使用@Resource注解实现byType自动注入
* 把spring配置文件中声明并在spring容器创建的service对象作为引用类型给控制器对象的属性赋值
* 相当于xml文件中的：
* <bean id="" class="org.example.controller.HelloController" autowire="byType">
* </bean>
*
* <bean id="" class="org.example.service.StudentService">
    <property.../>
* </bean>
* 所以在控制器对象中可以直接调用service对象的方法
* 不需要再先从servletContext全局作用域中获取spring容器对象再通过容器对象获取service对象
*
* */
