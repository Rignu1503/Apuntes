package com.rigo.springboot.app.interceptor.springboot_interceptor.interceptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component("timeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //Obtener nombre
        HandlerMethod cotroller = (HandlerMethod) handler;

        logger.info("LoadingTimeInterceptor: presHandler() entrando ...." + cotroller.getMethod().getName());

        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);

        Random rand = new Random();
        int delay = rand.nextInt(500);
        Thread.sleep(delay);
        /*

        //Crear un json y convertirlo en response
        Map<String, String> json = new HashMap<>();
        json.put("error", "No tienes acceso");
        json.put("date", new Date().toString());

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(json);
        response.setContentType("application/json");
        response.setStatus(401);
        response.getWriter().write(jsonString);

        return false;
        */
        return true;



    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);

        long endTime = System.currentTimeMillis();
        long start = (long) request.getAttribute("startTime");
        long duration = (endTime - start);
        logger.info("Tiempo transcurrido " + duration + " milisegundos");

        logger.info("LoadingTimeInterceptor: postHandler() Saliendo ...." + ((HandlerMethod) handler).getMethod().getName());

    }
}
