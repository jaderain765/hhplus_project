package com.hhplus.task.domain.concert.repositories;

import com.hhplus.task.domain.concert.models.ConcertApplyHistory;
import com.hhplus.task.domain.concert.models.ConcertApplyHistoryEntity;

public interface ConcertApplyHistoryModifierRepository {

    ConcertApplyHistory registOrUpdateHistory(ConcertApplyHistory concertApplyHistory);
}
