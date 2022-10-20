package com.example.demo.configuration;

import com.example.demo.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Autowired
    private TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自己的拦截器,并设置拦截的请求路径
        //addPathPatterns为拦截此请求路径的请求
        //excludePathPatterns为不拦截此路径的请求
        registry.addInterceptor(tokenInterceptor).addPathPatterns("/*").excludePathPatterns("/signup");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/*/**")  //设置所有的请求可以进行跨域
                .allowedOrigins("*")  //允许跨域的ip
                .allowedMethods("*")  //请求的方法 可以不设置 有默认的
                .allowedMethods("GET","POST","PUT","DELETE","HEAD","OPTIONS")//允许哪些方法访问
                .allowCredentials(true)//是否允许携带cookie
                .allowedHeaders("*") //请求头 可以不设置 有默认的
                .exposedHeaders("*");
    }
}