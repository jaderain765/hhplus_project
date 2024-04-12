package com.hhplus.task.domain.concert.infrastructure;

import com.hhplus.task.domain.concert.models.ConcertApplyHistoryEntity;
import com.hhplus.task.domain.concert.models.ConcertApplyHistoryPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConcertApplyHistoryJpaRepository extends JpaRepository<ConcertApplyHistoryEntity, ConcertApplyHistoryPK> {

    List<ConcertApplyHistoryEntity> findAllByConcertId(Long concertId);

    Long countByConcertId(Long concertId);

}
