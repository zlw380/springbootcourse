package com.example.config;

import com.example.web.MyFilter;
import com.example.web.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;
import javax.servlet.Servlet;

@Configuration
public class WebSystemConfig {

    //注册Servlet
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        Servlet servlet = new MyServlet();
        ServletRegistrationBean bean = new ServletRegistrationBean();
        bean.setServlet(servlet);
        bean.addUrlMappings("/myservlet");
        return bean;
    }

    //注册Filter
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean reg = new FilterRegistrationBean();
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("utf-8");
        filter.setForceEncoding(true);

        reg.setFilter(filter);
        reg.addUrlPatterns("/*");
        return reg;
    }

    @Bean
    public FilterRegistrationBean filterRegistration() {
        Filter filter = new MyFilter();
        //new一个FilterRegistrationBean类对象，传入自定义过滤器对象
        FilterRegistrationBean bean = new FilterRegistrationBean(filter);
        //设置要过滤哪些访问请求
        bean.addUrlPatterns("/*");
        return bean;
    }
}
