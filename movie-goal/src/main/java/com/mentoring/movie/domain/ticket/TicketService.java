package com.mentoring.movie.domain.ticket;

import com.mentoring.movie.domain.movie.Movie;
import com.mentoring.movie.domain.movie.MovieService;
import com.mentoring.movie.domain.ticket.dto.TicketRequest;
import com.mentoring.movie.domain.ticket.dto.TicketResponse;
import com.mentoring.movie.global.IdResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;
    private final MovieService movieService;

    public IdResponse<Long> createTicket(final TicketRequest ticketRequest) {
        final Movie movie = movieService.getEntity(ticketRequest.getMovieId());
        final Ticket ticket = ticketMapper.toEntity(ticketRequest, movie);
        final Long id = ticketRepository.save(ticket).getId();

        return new IdResponse<>(id);
    }

    public void deleteTicket(final Long id) {
        ticketRepository.deleteById(id);
    }

    public List<TicketResponse> getTicketsByMemberNickname(final String memberNickname) {
        final List<Ticket> tickets = ticketRepository.findAllByMemberNickname(memberNickname);
        return ticketMapper.toResponses(tickets);
    }
}
