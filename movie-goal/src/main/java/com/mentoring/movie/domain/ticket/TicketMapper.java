package com.mentoring.movie.domain.ticket;

import com.mentoring.movie.domain.movie.Movie;
import com.mentoring.movie.domain.ticket.dto.TicketRequest;
import com.mentoring.movie.domain.ticket.dto.TicketResponse;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketMapper {

    public Ticket toEntity(final TicketRequest ticketRequest, final Movie movie) {
        return Ticket.builder()
                .seatNumber(ticketRequest.getSeatNumber())
                .memberNickname(ticketRequest.getMemberNickname())
                .movie(movie)
                .build();
    }

    public List<TicketResponse> toResponses(final List<Ticket> tickets) {
        return tickets.stream().map(this::toResponse).toList();
    }

    private TicketResponse toResponse(final Ticket ticket) {
        return TicketResponse.builder()
                .id(ticket.getId())
                .title(ticket.getMovie().getTitle())
                .seatNumber(ticket.getSeatNumber())
                .memberNickname(ticket.getMemberNickname())
                .build();
    }
}
