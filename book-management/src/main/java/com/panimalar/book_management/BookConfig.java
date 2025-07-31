package com.panimalar.book_management;

import com.panimalar.book_management.interceptor.BookInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class BookConfig implements WebMvcConfigurer {
    @Autowired
    BookInterceptor bookInterceptor;

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(bookInterceptor).addPathPatterns("/book");
    }
}
