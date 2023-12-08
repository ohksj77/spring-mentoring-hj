package com.mentoring.movie.domain.ticket;

import com.mentoring.movie.domain.movie.Movie;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Ticket {

    @Id @GeneratedValue private Long id;

    private Integer seatNumber;

    private String memberNickname;

    private LocalDateTime reservationTime;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

    @Builder
    public Ticket(final Integer seatNumber, final String memberNickname, final Movie movie) {
        this.seatNumber = seatNumber;
        this.memberNickname = memberNickname;
        this.reservationTime = LocalDateTime.now();
        organizeMovie(movie);
    }

    private void organizeMovie(final Movie movie) {
        this.movie = movie;
        this.movie.organizeTicket(this);
    }

    public boolean hasSameSeatNumber(final Ticket ticket) {
        return this.seatNumber.equals(ticket.seatNumber);
    }
}
