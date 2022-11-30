package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController //해당 class는 rest api를 처리하는 controller로 등록
@RequestMapping("/api/get")  //uri를 지정해주는 Annotation
public class ApiController {

    @GetMapping("/hello") //http://localhost:9090/api/get/hello
    public String hello(){
        return "안녕 스프링 부트";
    }
    @GetMapping(path="/hell0") //ctrl+클릭시 가능한값 알려줌
    public String getHello0(){
        return "get Hello0";
    }

    @RequestMapping(path="hello1", method = RequestMethod.GET) //과거방식 , method = RequestMethod.GET부분을 지우면 get, put, post, delete 모두 가능해짐
    public String getHello1(){
        return "get Hello1";
    }

    //http://loaclhost:9090/api/get/path-varable/{name}
    @GetMapping("/path-variable/{name}")  //variable을 통하여 변화하는 부분을 받아야 함
    public String pathVariable(@PathVariable() String name){

        System.out.println("PathVariable: " + name);

        return name;
    }

//    //http://loaclhost:9090/api/get/path-varable/{id}
//    @GetMapping("/path-variable/{id}")  //variable을 통하여 변화하는 부분을 받아야 함
//    public String pathVariable(@PathVariable(name = "id") String pathName){
//
//        System.out.println("PathVariable: " + pathName);
//
//        return pathName;
//    }

    //쿼리 파람류
    //http://loaclhost:9090/api/get/query-param?user=hwang&email=hwangik42@naver.com
    @GetMapping("query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach( entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey()+": "+entry.getValue()+"\n");
        });
        return sb.toString();
    }

    @GetMapping("query-param02")
    public String queryParam2(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){
        return name+" "+email+" "+age;
    }

    //추천
    @GetMapping("query-param03")
    public String queryParam3(UserRequest userRequest){ //dto의 UserRequest와 연동

        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }

}

