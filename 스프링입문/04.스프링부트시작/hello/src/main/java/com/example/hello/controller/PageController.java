package com.example.hello.controller;

import com.example.hello.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @RequestMapping("/main")
    public String main(){
        return "main.html";
    }

    @ResponseBody
    @GetMapping("/user")
    public User user(){
        var user = new User(); // User user = new User();의 간소화된 버전
        user.setName("Hwang");
        user.setAddress("지구");
        return user;
    }
}
