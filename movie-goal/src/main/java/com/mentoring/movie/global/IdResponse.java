package com.mentoring.movie.global;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class IdResponse<T> {

    private T id;
}
