package com.mentoring.movie.domain.movie;

import com.mentoring.movie.domain.movie.dto.MovieRequest;
import com.mentoring.movie.domain.movie.dto.MovieResponse;
import com.mentoring.movie.global.EntityNotFoundException;
import com.mentoring.movie.global.IdResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public IdResponse<Long> createMovie(final MovieRequest movieRequest) {
        final Movie movie = movieMapper.toMovie(movieRequest);
        final Long id = movieRepository.save(movie).getId();
        return new IdResponse<>(id);
    }

    public MovieResponse getMovie(final Long id) {
        final Movie movie = getEntity(id);
        return movieMapper.toResponse(movie);
    }

    public Movie getEntity(final Long id) {
        return movieRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<MovieResponse> getMoviesByTitle(final String title) {
        final List<Movie> movies = movieRepository.findAllByTitleContainingIgnoreCase(title);
        return movieMapper.toResponses(movies);
    }

    public List<MovieResponse> getMoviesByGenre(final Genre genre) {
        final List<Movie> movies = movieRepository.findAllByGenre(genre);
        return movieMapper.toResponses(movies);
    }

    public List<MovieResponse> getMovies() {
        final List<Movie> movies = movieRepository.findAll();
        return movieMapper.toResponses(movies);
    }

    @Transactional
    public void activate(final Long id) {
        final Movie movie = getEntity(id);
        movie.activate();
    }

    @Transactional
    public void inactivate(final Long id) {
        final Movie movie = getEntity(id);
        movie.inactivate();
    }

    public void deleteMovie(final Long id) {
        movieRepository.deleteById(id);
    }
}
