package com.rigo.springboot.app.interceptor.calendar.springboot_horario;

import com.rigo.springboot.app.interceptor.calendar.springboot_horario.interceptor.CalendarInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    @Qualifier("calendar")
    private HandlerInterceptor calendarHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(calendarHandlerInterceptor).addPathPatterns("/foo");

    }
}
