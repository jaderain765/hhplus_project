package com.hhplus.task.domain.concert.infrastructure;

import com.hhplus.task.domain.concert.models.ConcertApplyHistory;
import com.hhplus.task.domain.concert.models.ConcertApplyHistoryEntity;
import com.hhplus.task.domain.concert.models.ConcertApplyHistoryPK;
import com.hhplus.task.domain.concert.models.QConcertApplyHistoryEntity;
import com.hhplus.task.domain.concert.repositories.ConcertApplyHistoryReaderRepository;
import com.hhplus.task.exception.CustomRuntimeException;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ConcertApplyHistoryCoreReaderRepository implements ConcertApplyHistoryReaderRepository {

    private final ConcertApplyHistoryJpaRepository concertApplyHistoryJpaRepository;

    JPAQueryFactory jpaQueryFactory;

    QConcertApplyHistoryEntity applyHistory = QConcertApplyHistoryEntity.concertApplyHistoryEntity;

    @Override
    public List<ConcertApplyHistory> findAllByConcertId(long concertId) {

        return concertApplyHistoryJpaRepository
                .findAllByConcertId(concertId)
                .stream()
                .map(e -> e.toConcertApplyHistory())
                .toList();
    }

    @Override
    public Long countByConcertId(long concertId) {
        return concertApplyHistoryJpaRepository.countByConcertId(concertId);
    }

    @Override
    public ConcertApplyHistory findById(ConcertApplyHistoryPK id) {
        Optional<ConcertApplyHistoryEntity> concertApplyHistoryEntity = concertApplyHistoryJpaRepository.findById(id);

        if(concertApplyHistoryEntity.isPresent())return concertApplyHistoryEntity.get().toConcertApplyHistory();

        throw new CustomRuntimeException("콘서트 기록을 찾을 수 없습니다.");
    }

    @Override
    public boolean isReservation(Integer seatNumber, Long concertId) {

        BooleanBuilder booleanBuilder = new BooleanBuilder();

        booleanBuilder
                .and(applyHistory.concertId.eq(concertId))
                .and(applyHistory.seatNumber.eq(seatNumber))
                .and(applyHistory.paymentTime.isNotNull() // 결제내역이 있거나
                        .or(applyHistory.reservationTime.after(LocalDateTime.now().minusMinutes(5L)))); // 예약하고 5분이 지난 경우

        Optional<ConcertApplyHistoryEntity> any = jpaQueryFactory.selectFrom(applyHistory)
                .where(booleanBuilder)
                .stream().findAny();

        return any.isEmpty();
    }


}
