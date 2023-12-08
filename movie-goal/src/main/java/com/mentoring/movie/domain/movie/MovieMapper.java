package com.mentoring.movie.domain.movie;

import com.mentoring.movie.domain.movie.dto.MovieRequest;
import com.mentoring.movie.domain.movie.dto.MovieResponse;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieMapper {

    public Movie toMovie(final MovieRequest movieRequest) {
        return Movie.builder()
                .title(movieRequest.getTitle())
                .introduce(movieRequest.getIntroduce())
                .genre(movieRequest.getGenre())
                .build();
    }

    public MovieResponse toResponse(final Movie movie) {
        return MovieResponse.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .introduce(movie.getIntroduce())
                .genre(movie.getGenre())
                .build();
    }

    public List<MovieResponse> toResponses(final List<Movie> movies) {
        return movies.stream().map(this::toResponse).toList();
    }
}
