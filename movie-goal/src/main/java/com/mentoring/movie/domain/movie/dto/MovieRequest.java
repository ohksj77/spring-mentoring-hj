package com.mentoring.movie.domain.movie.dto;

import com.mentoring.movie.domain.movie.Genre;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequest {
    private String title;
    private String introduce;
    private Genre genre;
}
