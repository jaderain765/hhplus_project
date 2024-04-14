package com.hhplus.task.domain.concert.repositories;

import com.hhplus.task.domain.concert.models.ConcertApplyHistory;

public interface ConcertApplyHistoryModifierRepository {

    ConcertApplyHistory registOrUpdateHistory(ConcertApplyHistory concertApplyHistory);
}
