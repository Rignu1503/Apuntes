package com.rigo.springboot.app.interceptor.springboot_interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class FooController {

    @GetMapping("/foo")
    public Map<String, Object> foo() {

        return Collections.singletonMap("Message", "hadler foo");
    }

    @GetMapping("/bar")
    public Map<String, Object> bar() {

        return Collections.singletonMap("Message", "hadler bar");
    }

    @GetMapping("/baz")
    public Map<String, Object> baz() {

        return Collections.singletonMap("Message", "hadler baz");
    }
}
