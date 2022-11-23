package com.example.hello.controller;

import com.example.hello.dto.PutRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutController {

    @PutMapping("/put")
    public PutRequestDto put(@RequestBody PutRequestDto requestDto){

        System.out.println(requestDto);
        return requestDto;
    }

    @PutMapping("/put02/{id}")
    public PutRequestDto put02(@RequestBody PutRequestDto requestDto, @PathVariable(name = "id") Long name){

        System.out.println(name);
        return requestDto;
    }
}

//{
//    "name":"",
//    "age":"",
//    "car_list":[
//        {
//        "name": "",
//        "car_number":""
//        },
//        {
//        "name": "",
//        "car_number":""
//        }
//    ]
// }