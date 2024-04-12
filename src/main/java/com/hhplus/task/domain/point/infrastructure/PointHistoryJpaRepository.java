package com.hhplus.task.domain.point.infrastructure;

import com.hhplus.task.domain.point.models.PointHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointHistoryJpaRepository extends JpaRepository<PointHistoryEntity, Long> {
}
