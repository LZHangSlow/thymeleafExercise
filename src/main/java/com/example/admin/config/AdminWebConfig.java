package com.example.admin.config;

import com.example.admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*
* 1、编写一个拦截器实现HandlerInterceptor接口
* 2、拦截器注册到spring容器中，也就是这个配置类实现WebMvcConfigurer的addInterceptors
* 3、指定拦截规则【如果是拦截所有（/**），静态资源也会被拦截】
* */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截所有请求，但是需要放行/和/login
        //  /**把静态资源也一并拦截了
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").
                excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**");
        System.out.println("拦截器执行了");
    }
}
