package com.example.web;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("执行了MyFilter.doFilter");
        //执行传入的过滤器链类对象filterChain中的doFilter方法
        //传入请求与响应对象，执行过滤操作
        //设置请求与响应对象中的参数
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
