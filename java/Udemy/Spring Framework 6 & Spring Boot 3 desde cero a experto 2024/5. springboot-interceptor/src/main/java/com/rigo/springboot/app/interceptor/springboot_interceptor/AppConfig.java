package com.rigo.springboot.app.interceptor.springboot_interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    @Qualifier("timeInterceptor")
    private HandlerInterceptor handlerInterceptor;
    // Existen muchos interceptores que implementan esta interfaz por eso se agrega cualificador

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //Para que interceptor solo se ejecute en bar y baz
        //registry.addInterceptor(handlerInterceptor).addPathPatterns("/app/bar", "/app/baz");

        //Excluir rita de interceptores
        registry.addInterceptor(handlerInterceptor).excludePathPatterns("/app/bar");
    }
}
