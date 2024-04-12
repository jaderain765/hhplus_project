package com.hhplus.task.domain.concert.infrastructure;

import com.hhplus.task.domain.concert.models.QConcertApplyHistoryEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ConcertApplyHistoryQuerydslRepository {

    JPAQueryFactory jpaQueryFactory;

    QConcertApplyHistoryEntity concertApplyHistory = QConcertApplyHistoryEntity.concertApplyHistoryEntity;

    /**
     * 콘서트 신청 기록을 통해 얼마나 좌석이 사용되었는지 찾는다.
     *
     * @return
     */
    public Map<Long, Long> findAllConcertIdAndCount(){

        return jpaQueryFactory
                .select(
                        concertApplyHistory.concertId.as("concertId"),
                        concertApplyHistory.concertId.count().as("count")
                ).from(concertApplyHistory)
                .groupBy(concertApplyHistory.concertId)
                .fetch()
                .stream().collect(Collectors.toMap(
                        tuple -> tuple.get(0, Long.class),
                        tuple -> tuple.get(1, Long.class)));
    }

    public Long countByConcertId(Long concertId){
        return jpaQueryFactory.select(concertApplyHistory.concertId.count())
                .from(concertApplyHistory)
                .where(concertApplyHistory.concertId.eq(concertId))
                .fetchOne();
    }
}
