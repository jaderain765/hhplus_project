package com.hhplus.task.domain.concert.repositories;

import com.hhplus.task.domain.concert.models.ConcertApplyHistory;
import com.hhplus.task.domain.concert.models.ConcertApplyHistoryEntity;
import com.hhplus.task.domain.concert.models.ConcertApplyHistoryPK;

import java.util.List;

public interface ConcertApplyHistoryReaderRepository {
    List<ConcertApplyHistory> findAllByConcertId(long concertId);

    Long countByConcertId(long concertId);

    ConcertApplyHistory findById(ConcertApplyHistoryPK id);

    boolean isReservation(Integer seatNumber, Long concertId);
}
