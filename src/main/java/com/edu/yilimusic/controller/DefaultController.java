package com.edu.yilimusic.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@CrossOrigin
public class DefaultController {

    @GetMapping
    public String sayHello(){
        return "欢迎光临,我有才！,天才,人才,庸才,蠢材！";
    }
}
