package com.mentoring.movie.domain.movie;

public class IllegalSeatNumberException extends IllegalArgumentException {

    private static final String MESSAGE = "이미 예약된 좌석 번호입니다.";

    public IllegalSeatNumberException() {
        super(MESSAGE);
    }
}
