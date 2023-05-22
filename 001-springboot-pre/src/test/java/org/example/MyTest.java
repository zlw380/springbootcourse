package org.example;

import org.example.config.SpringConfig;
import org.example.vo.Cat;
import org.example.vo.Student;
import org.example.vo.Tiger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    /*使用xml作为容器配置文件*/
    @Test
    public void test01() {
        String config = "beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Student student = (Student) ctx.getBean("myStudent");
        System.out.println("容器的对象：" + student);
    }

    /*使用JavaConfig*/
    @Test
    public void test02() {
        /*使用通过注解配置类创建spring容器的实现类，参数是类对象*/
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        Student student = (Student) ctx.getBean("createStudent");
        System.out.println("使用JavaConfig创建的Bean对象：" + student);
    }

    @Test
    public void test03() {
        /*使用通过注解配置类创建spring容器的实现类，参数是类对象*/
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        Student student = (Student) ctx.getBean("lisiStudent");
        System.out.println("使用JavaConfig创建的Bean对象：" + student);
    }

    @Test
    public void test04() {
        /*使用通过注解配置类创建spring容器的实现类，参数是类对象*/
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        Cat myCat = (Cat) ctx.getBean("myCat");
        System.out.println("使用JavaConfig创建的Bean对象：" + myCat);
    }

    @Test
    public void test05() {
        /*使用通过注解配置类创建spring容器的实现类，参数是类对象*/
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        Tiger myTiger = (Tiger) ctx.getBean("tiger");
        System.out.println("使用JavaConfig创建的Bean对象：" + myTiger);
    }
}
