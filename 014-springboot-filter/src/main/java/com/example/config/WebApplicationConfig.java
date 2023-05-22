package com.example.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class WebApplicationConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        Filter filter = new com.example.web.Filter();
        //new一个FilterRegistrationBean类对象，传入自定义过滤器对象
        FilterRegistrationBean bean = new FilterRegistrationBean(filter);
        //设置要过滤哪些访问请求
        bean.addUrlPatterns("/user/*");

        return bean;

    }
}

/*注册过滤器后就算是服务器找不到请求的资源也会照常执行过滤器
 *
 * 字符集过滤器类CharacterEncodingFilter是由springmvc框架提供的
 * 它实现了Servlet中的Filter接口*/

/*FilterRegistrationBean类：
  public class FilterRegistrationBean<T extends Filter> extends AbstractFilterRegistrationBean<T>{
      private T filter;
      ...
  }
  T是Java泛型中的一个标记符号,代表Type(Java 类)。
  这个类需要的泛型对象是要继承过滤器对象Filter
  (这个容器中所包含的对象T是继承了Filter类的对象
  就如同List<Student>代表list集合中包含的对象是Student类的对象
  而List<E>就表示一个List集合泛型类，其中的泛型标记符是E
  E - Element (在集合中使用，因为集合中存放的是元素)
  E就是Student的泛型
  )

  使用“class 名称<泛型列表>”声明一个类，为了和普通类有所区别，这样声明的类称作泛型类。
  class People<E>
  People是泛型类的名称，E是其中的泛型
  ”泛型列表“给出的泛型可以作为类的成员变量的类型、方法的类型以及局部变量的类型

  而ServletRegistrationBean<?>... servletRegistrationBeans中
  ?是通配符,泛指所有类型
  表示ServletRegistrationBean<T extends Servlet>中的T
  即ServletRegistrationBean类中的属性T是继承了Servlet接口的对象
  ServletRegistrationBean类被实例化后，属性T就被赋值为自定义servlet类型的对象
  然后返回servletRegistrationBean对象以注册servlet对象
  因此在注册过滤器对象时
  servletRegistrationBean对象作为参数传入FilterRegistrationBean对象完全可以使用通配符<?>
  来代表各种自定义的servlet对象

  创建泛型类对象后，对象中泛型属性已按界限赋值
  再将泛型类对象作为参数传入某个方法时类名后使用通配符<?>即可
* */

