package com.example.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.PublicKey;

@Controller
public class TaskController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}