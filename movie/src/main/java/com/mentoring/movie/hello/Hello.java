package com.mentoring.movie.hello;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Hello {
    private String hello;
    private Integer num;

    public void increase() {
        this.num++;
    }
}
