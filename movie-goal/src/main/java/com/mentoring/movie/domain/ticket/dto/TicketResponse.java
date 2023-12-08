package com.mentoring.movie.domain.ticket.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class TicketResponse {
    private Long id;
    private Integer seatNumber;
    private String memberNickname;
    private String title;
}
