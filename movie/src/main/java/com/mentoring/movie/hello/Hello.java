package com.mentoring.movie.hello;

public class Hello {

    private String hello;
    private Integer num;

    public void increase() {
        this.num++;
    }

    public Hello(String hello, Integer num) {
        this.hello = hello;
        this.num = num;
    }

    public String getHello() {
        return hello;
    }

    public Integer getNum() {
        return num;
    }
}
