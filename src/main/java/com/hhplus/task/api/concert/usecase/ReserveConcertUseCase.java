package com.hhplus.task.api.concert.usecase;

import com.hhplus.task.api.concert.dto.ConcertRequestDto;
import com.hhplus.task.domain.concert.component.ConcertModifier;
import com.hhplus.task.domain.concert.models.ConcertApplyHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class ReserveConcertUseCase {

    private ConcertModifier concertModifier;

    public ConcertApplyHistory execute(ConcertRequestDto concertRequestDto){

        concertRequestDto.valid();

        // 예약처리
        return concertModifier.reserveConcert(
                concertRequestDto.getConcertId(),
                concertRequestDto.getSeatNumber(),
                concertRequestDto.getUserId());
    }
}

