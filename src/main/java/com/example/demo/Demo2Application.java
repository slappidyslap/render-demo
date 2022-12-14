package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Demo2Application {

    private final GreetingRepo greetingRepo;

    public Demo2Application(GreetingRepo greetingRepo) {
        this.greetingRepo = greetingRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);
    }

    @GetMapping("/test")
    String test() {
        return "Hello, Render!";
    }

    @PostMapping("/new/{content}")
    Greeting newGreeting(@PathVariable String content) {
        return greetingRepo.save(new Greeting(content));
    }

}
