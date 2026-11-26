package dev.echoforge.rest.libros.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping
    public String demo(){
        return "REST API - Java Spring Boot 4";
    }
}
