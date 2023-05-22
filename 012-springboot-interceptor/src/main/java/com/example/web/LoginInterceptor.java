package com.example.web;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*自定义拦截器*/

public class LoginInterceptor implements HandlerInterceptor {

    /*handler:被拦截的控制器对象
     * 返回值是boolean类型
     * true：请求能被Controller处理
     * false：请求被截断*/
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println("执行了LoginInterceptor的preHandle");
        return true;
    }
}
