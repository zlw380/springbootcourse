package com.example.config;

import com.example.servlet.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServlet;
import java.util.Collections;

@Configuration
public class WebApplicationConfig {
    //定义方法，注册servlet对象
    //@Bean注解，相当于xml文件中使用bean标签声明对象
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {

        // public ServletRegistrationBean(T servlet, String... urlMappings)
        //第一个参数是Servlet对象，第二个参数是url地址
        /*ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new MyServlet(),
                "/myservlet");*/

        HttpServlet servlet = new MyServlet();
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(servlet);
        servletRegistrationBean.addUrlMappings("/myservlet", "/login");//<url-pattern>
        return servletRegistrationBean;
    }
}

/*tips：注册拦截器对象就不需要像一般的JavaConfig配置类一样需要在注册对象的方法上加@Bean注解
 *       addInterceptors(InterceptorRegistry registry)方法会把拦截器对象及其要拦截的请求uri地址
 *       放入传入的registry对象作用域当中*/
