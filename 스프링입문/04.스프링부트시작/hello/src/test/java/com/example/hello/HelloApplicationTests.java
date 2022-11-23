package com.example.hello;

import com.example.hello.controller.User01;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class HelloApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {

    var objectMapper = new ObjectMapper();

    var user01 = new User01("hwang", 10);

    var text = objectMapper.writeValueAsString(user01);

    var objectUser01 = objectMapper.readValue(text, User01.class);

    }

}
