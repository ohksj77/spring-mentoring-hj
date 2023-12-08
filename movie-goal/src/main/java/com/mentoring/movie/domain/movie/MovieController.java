package com.mentoring.movie.domain.movie;

import com.mentoring.movie.domain.movie.dto.MovieRequest;
import com.mentoring.movie.domain.movie.dto.MovieResponse;
import com.mentoring.movie.global.IdResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("movies")
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IdResponse<Long> createMovie(@RequestBody final MovieRequest movieRequest) {
        return movieService.createMovie(movieRequest);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public MovieResponse getMovie(@PathVariable final Long id) {
        return movieService.getMovie(id);
    }

    @GetMapping("title")
    @ResponseStatus(HttpStatus.OK)
    public List<MovieResponse> getMoviesByTitle(@RequestParam final String title) {
        return movieService.getMoviesByTitle(title);
    }

    @GetMapping("genre")
    @ResponseStatus(HttpStatus.OK)
    public List<MovieResponse> getMoviesByGenre(@RequestParam final Genre genre) {
        return movieService.getMoviesByGenre(genre);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MovieResponse> getMovies() {
        return movieService.getMovies();
    }

    @PostMapping("active/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void activeMovie(@PathVariable final Long id) {
        movieService.activate(id);
    }

    @PostMapping("inactive/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void inactiveMovie(@PathVariable final Long id) {
        movieService.inactivate(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable final Long id) {
        movieService.deleteMovie(id);
    }
}
