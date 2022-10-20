package com.example.demo.interceptor;


import com.example.demo.enums.ResultEnum;
import com.example.demo.result.Result;
import com.example.demo.utils.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!(handler instanceof HandlerMethod))
            return true;
        //放行OPTIONS请求
        String method = request.getMethod();
        if ("OPTIONS".equals(method)) {
            return true;
        }

        System.out.println(request.getRequestURI());
        // if(!JwtUtil.checkToken(request)){
        //     System.out.println("Token无效！");
        //     // return false;
        // }
        return true;
    }
}
