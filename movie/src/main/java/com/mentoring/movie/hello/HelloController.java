package com.mentoring.movie.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping
    public String helloWorld() {
        return "Hello Spring!";
    }

    @GetMapping("{number1}/{number2}")
    public Integer sum(Integer number1, Integer number2) {
        return number1 + number2;
    }

    @GetMapping("hello/{hello}/{num}")
    public Hello helloGet(String hello, Integer num) {
        return new Hello(hello, num);
    }

    @PostMapping
    public Hello helloPost(@RequestBody Hello hello) {
        return hello;
    }

    @PostMapping("increase")
    public Hello helloIncrease(@RequestBody Hello hello) {
        hello.increase();
        return hello;
    }
}
