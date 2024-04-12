package com.hhplus.task.domain.concert.infrastructure;

import com.hhplus.task.domain.concert.models.QConcertApplyHistoryEntity;
import com.hhplus.task.domain.concert.models.QConcertEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class ConcertQureydslRepository{

    JPAQueryFactory jpaQueryFactory;

    QConcertEntity concert = QConcertEntity.concertEntity;
    QConcertApplyHistoryEntity  history = QConcertApplyHistoryEntity.concertApplyHistoryEntity;

}
