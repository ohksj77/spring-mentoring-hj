package com.mentoring.movie.domain.ticket;

import com.mentoring.movie.domain.global.IdResponse;
import com.mentoring.movie.domain.ticket.dto.TicketRequest;

import com.mentoring.movie.domain.ticket.dto.TicketResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("tickets")
public class TicketController {

    private final TicketService ticketService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IdResponse<Long> createTicket(@RequestBody final TicketRequest ticketRequest) {
        return ticketService.createTicket(ticketRequest);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTicket(@PathVariable final Long id) {
        ticketService.deleteTicket(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TicketResponse> getTicketsByMemberNickname(
            @RequestBody final String memberNickname) {
        return ticketService.getTicketsByMemberNickname(memberNickname);
    }
}
