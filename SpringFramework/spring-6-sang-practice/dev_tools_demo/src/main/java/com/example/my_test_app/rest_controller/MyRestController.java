package com.example.my_test_app.rest_controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 5k !";
    }

    @GetMapping("/tryAgain")
    public String getLetTryAgain(){
        return "If you see this, it is success!";
    }
}
