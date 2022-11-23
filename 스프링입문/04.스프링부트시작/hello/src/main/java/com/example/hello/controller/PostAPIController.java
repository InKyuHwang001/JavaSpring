package com.example.hello.controller;

import com.example.hello.dto.PostRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/post")
public class PostAPIController {

    @PostMapping("/post0")
    public void post0(@RequestBody Map<String, Object> requestData){

//        requestData.entrySet().forEach(stringObjectEntry -> {
//            System.out.println("key: "+stringObjectEntry.getKey());
//            System.out.println("value: "+stringObjectEntry.getValue());
//        });
        requestData.forEach((key, value) -> {
            System.out.println("key: " + key);
            System.out.println("value: " + value);
        });
    }

    @PostMapping("/post2")
    public void post1(@RequestBody PostRequestDto requestData){
        System.out.println(requestData);
    }

}
//Json 형태
//sting : value
//number: value
//boolen: value
//object: value { }
//array: value [ ]
//
//{
//    "account": "",
//    "email": ""
//}