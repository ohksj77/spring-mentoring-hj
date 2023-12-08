package com.mentoring.movie.domain.movie;

import com.mentoring.movie.domain.ticket.Ticket;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie {

    @Id @GeneratedValue private Long id;

    @Column(unique = true, nullable = false)
    private String title;

    private String introduce;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Enumerated(EnumType.STRING)
    private MovieStatus movieStatus;

    @OneToMany(mappedBy = "movie")
    private List<Ticket> tickets;

    @Builder
    public Movie(final String title, final String introduce, final Genre genre) {
        this.title = title;
        this.introduce = introduce;
        this.genre = genre;
        this.movieStatus = MovieStatus.ACTIVE;
    }

    public void activate() {
        this.movieStatus = MovieStatus.ACTIVE;
    }

    public void inactivate() {
        this.movieStatus = MovieStatus.INACTIVE;
    }

    public void organizeTicket(final Ticket ticket) {
        validateSeatNumber(ticket);
        this.tickets.add(ticket);
    }

    private void validateSeatNumber(final Ticket ticket) {
        if (isReservedSeat(ticket)) {
            throw new IllegalSeatNumberException();
        }
    }

    private boolean isReservedSeat(final Ticket ticket) {
        return this.tickets.stream().anyMatch(t -> t.hasSameSeatNumber(ticket));
    }
}
