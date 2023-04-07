package com.example.maven.controller;

import com.example.maven.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping(value = {"/hello-world", "hello"}, method = RequestMethod.GET)
    public String helloWord() {
        return "Hello World";
    }

    @GetMapping(value={"/get-info"})
    public User getInfo(){
//        User user = new User(1, "Nguyễn Phước Sang");
        return null;
    }

//    @GetMapping(value = {"get-info-with-status"})
//    public ResponseEntity<User> getInfoWithStatus(){
//        User user = new User(2, "Nguyễn Văn An");
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
//    }
}
