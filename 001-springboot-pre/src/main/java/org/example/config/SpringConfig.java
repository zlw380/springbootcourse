package org.example.config;

import org.example.vo.Student;
import org.springframework.context.annotation.*;

/*@Configuration:表示当前类是作为配置文件使用的，就是用来配置容器的
 * 位置：在类的上面
 * 此时，SpringConfig这个类相当于applicationContext.xml*/
@Configuration

/*引入其他xml配置文件*/
@ImportResource(value = {"classpath:applicationContext.xml",
        "classpath:beans.xml"})

/*引入外部properties属性配置文件
 * 作用等同于xml文件里的：<context:property-placeholder location="classpath:jdbc.properties"/>*/
@PropertySource(value = "classpath:config.properties")

/*声明组件扫描器*/
@ComponentScan(basePackages = "org.example.vo")
public class SpringConfig {

    /*创建方法，方法的返回值是对象，在方法的上面加入@Bean
     * 方法的返回值对象就注入到容器中
     *
     * @Bean:把对象注入到spring容器中，作用相当于<bean>标签
     * 位置：方法的上面
     *
     * 说明：@Bean,如果不指定对象的名称，默认方法名是容器中对象的id*/
    @Bean
    public Student createStudent() {
        Student s1 = new Student();
        s1.setName("zhangsan");
        s1.setAge(26);
        s1.setSex("male");
        return s1;
    }

    /*指定对象在容器中的名称(指定<bean>的id属性)
     * @Bean的name属性，指定对象的名称(id)*/
    @Bean(name = "lisiStudent")
    public Student makeStudent() {
        Student s2 = new Student();
        s2.setName("liuwu");
        s2.setAge(22);
        s2.setSex("female");
        return s2;
    }


}
