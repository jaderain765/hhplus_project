package com.hhplus.task.domain.concert.infrastructure;

import com.hhplus.task.domain.concert.models.ConcertApplyHistory;
import com.hhplus.task.domain.concert.models.ConcertApplyHistoryEntity;
import com.hhplus.task.domain.concert.repositories.ConcertApplyHistoryModifierRepository;

public class ConcertApplyHistoryCoreModifierRepository implements ConcertApplyHistoryModifierRepository {

    private ConcertApplyHistoryJpaRepository concertApplyHistoryJpaRepository;

    @Override
    public ConcertApplyHistory registOrUpdateHistory(ConcertApplyHistory concertApplyHistory) {
        return concertApplyHistoryJpaRepository
                .save(new ConcertApplyHistoryEntity(concertApplyHistory))
                .toConcertApplyHistory();
    }
}
