package com.mentoring.movie.domain.movie.dto;

import com.mentoring.movie.domain.movie.Genre;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MovieResponse {
    private Long id;
    private String title;
    private String introduce;
    private Genre genre;
}
