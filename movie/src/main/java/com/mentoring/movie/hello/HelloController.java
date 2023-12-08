package com.mentoring.movie.hello;


import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
@RequiredArgsConstructor
public class HelloController {

    @GetMapping
    public String helloWorld() {
        return "Hello Spring!";
    }

    @GetMapping("{num}/{number}")
    public Integer sum(
            @PathVariable(name = "num") Integer num,
            @PathVariable(name = "number") Integer number) {

        return num + number;
    }

    @GetMapping("hello/{hello}/{num}")
    public Hello helloGet(
            @PathVariable(name = "hello") String hello, @PathVariable(name = "num") Integer num) {
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
