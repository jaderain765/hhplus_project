package com.hhplus.task.domain.concert.infrastructure;

import com.hhplus.task.domain.concert.models.ConcertEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcertJpaRepository extends JpaRepository<ConcertEntity, Long> {
}
