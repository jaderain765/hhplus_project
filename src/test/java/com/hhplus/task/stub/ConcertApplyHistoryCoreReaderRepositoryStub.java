package com.hhplus.task.stub;


import com.hhplus.task.domain.concert.infrastructure.ConcertApplyHistoryCoreReaderRepository;
import com.hhplus.task.domain.concert.models.ConcertApplyHistory;
import com.hhplus.task.domain.concert.models.ConcertApplyHistoryEntity;
import com.hhplus.task.domain.concert.models.ConcertApplyHistoryPK;
import com.hhplus.task.domain.concert.repositories.ConcertApplyHistoryReaderRepository;

import java.util.List;

public class ConcertApplyHistoryCoreReaderRepositoryStub implements ConcertApplyHistoryReaderRepository {
    @Override
    public List<ConcertApplyHistory> findAllByConcertId(long concertId) {
        return null;
    }

    @Override
    public Long countByConcertId(long concertId) {
        return null;
    }

    @Override
    public ConcertApplyHistory findById(ConcertApplyHistoryPK id) {
        return null;
    }

    @Override
    public boolean isReservation(Integer seatNumber, Long concertId) {
        return false;
    }
}
