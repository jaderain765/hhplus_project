package com.hhplus.task.domain.concert.repositories;

import com.hhplus.task.domain.concert.models.ConcertApplyHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcertApplyHistoryModifierRepository {

    ConcertApplyHistory registOrUpdateHistory(ConcertApplyHistory concertApplyHistory);
}
