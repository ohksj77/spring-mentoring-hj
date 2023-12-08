package com.mentoring.movie.domain.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAllByTitleContainingIgnoreCase(final String title);

    List<Movie> findAllByGenre(final Genre genre);
}
