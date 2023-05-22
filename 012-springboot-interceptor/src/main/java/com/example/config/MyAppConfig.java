package com.example.config;

import com.example.web.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*配置类需要加注解，起到xml配置文件的作用,把自定义拦截器加入到容器当中*/
@Configuration
public class MyAppConfig implements WebMvcConfigurer {

    //注册拦截器对象，注入到容器中
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //创建拦截器对象，即自定义的拦截器对象
        HandlerInterceptor handlerInterceptor = new LoginInterceptor();
        //注册拦截器对象并指定拦截的请求uri地址
        //指定拦截与不拦截的请求uri地址
        String[] path = {"/user/**", "/admin/**"};
        String[] excludePath = {"/user/login"};
        registry.addInterceptor(handlerInterceptor)
                .addPathPatterns(path)
                .excludePathPatterns(excludePath);

    }
}
