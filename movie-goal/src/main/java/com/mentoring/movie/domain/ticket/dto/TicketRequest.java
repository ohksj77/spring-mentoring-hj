package com.mentoring.movie.domain.ticket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TicketRequest {
    private Long movieId;
    private Integer seatNumber;
    private String memberNickname;
}
