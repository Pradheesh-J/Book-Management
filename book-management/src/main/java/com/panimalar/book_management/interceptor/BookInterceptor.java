package com.panimalar.book_management.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class BookInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("This is before the controller");
        return true;
    }

    public boolean postHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("This is after the controller");
        return true;
    }

    public boolean afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("This is after completion of the Interceptor");
        return true;
    }
}
