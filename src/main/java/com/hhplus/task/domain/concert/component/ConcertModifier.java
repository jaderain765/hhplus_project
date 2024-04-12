package com.hhplus.task.domain.concert.component;

import com.hhplus.task.domain.concert.models.ConcertApplyHistory;
import com.hhplus.task.domain.concert.models.ConcertApplyHistoryPK;
import com.hhplus.task.domain.concert.repositories.ConcertApplyHistoryModifierRepository;
import com.hhplus.task.domain.concert.repositories.ConcertApplyHistoryReaderRepository;
import com.hhplus.task.domain.concert.repositories.ConcertReaderRepository;
import com.hhplus.task.domain.concert.repositories.ConcertStoreRepository;
import com.hhplus.task.exception.CustomRuntimeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class ConcertModifier {

    private ConcertReaderRepository concertReaderRepository;
    private ConcertStoreRepository concertStoreRepository;

    private ConcertApplyHistoryReaderRepository concertApplyHistoryReaderRepository;
    private ConcertApplyHistoryModifierRepository concertApplyHistoryModifierRepository;

    /**
     * 콘서트 예약
     *
     * @param concertId
     * @param seatNumber
     */
    @Transactional
    public ConcertApplyHistory reserveConcert(long concertId, int seatNumber, long userId){

        if(concertApplyHistoryReaderRepository.isReservation(seatNumber, concertId))
            throw new CustomRuntimeException("해당 공연은 신청 할 수 없습니다.");

        ConcertApplyHistory concertApplyHistory = ConcertApplyHistory.builder()
                .seatNumber(seatNumber)
                .concertId(concertId)
                .userId(userId)
                .reservationTime(LocalDateTime.now())
                .build();

        return concertApplyHistoryModifierRepository.registOrUpdateHistory(concertApplyHistory);
    }


    @Transactional
    public ConcertApplyHistory payConcert(long concertId, int seatNumber, long userId){

        ConcertApplyHistory concertApplyHistory = concertApplyHistoryReaderRepository.findById(ConcertApplyHistoryPK.builder()
                .concertId(concertId)
                .seatNumber(seatNumber)
                .build());

        if(!concertApplyHistory.getUserId().equals(userId))
            throw new CustomRuntimeException("다른 사용자가 예약한 공연입니다.");

        if(concertApplyHistory.getReservationTime().isBefore(LocalDateTime.now().minusMinutes(5L)))
            throw new CustomRuntimeException("예약정보가 만료되었습니다.");


        ConcertApplyHistory payConcertApplyHistory = ConcertApplyHistory.builder()
                .seatNumber(seatNumber)
                .concertId(concertId)
                .userId(userId)
                .paymentTime(LocalDateTime.now())
                .build();

        return concertApplyHistoryModifierRepository.registOrUpdateHistory(payConcertApplyHistory);
    }
}
