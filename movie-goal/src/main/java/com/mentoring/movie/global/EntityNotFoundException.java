package com.mentoring.movie.global;

public class EntityNotFoundException extends IllegalArgumentException {

    private static final String MESSAGE = "엔티티를 조회할 수 없습니다.";

    public EntityNotFoundException() {
        super(MESSAGE);
    }
}
