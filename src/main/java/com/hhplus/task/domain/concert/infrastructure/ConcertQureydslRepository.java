package com.hhplus.task.domain.concert.infrastructure;

import com.hhplus.task.domain.concert.models.QConcertApplyHistoryEntity;
import com.hhplus.task.domain.concert.models.QConcertEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ConcertQureydslRepository{

    private final JPAQueryFactory jpaQueryFactory;

    private QConcertEntity concert = QConcertEntity.concertEntity;
    private QConcertApplyHistoryEntity  history = QConcertApplyHistoryEntity.concertApplyHistoryEntity;

}
