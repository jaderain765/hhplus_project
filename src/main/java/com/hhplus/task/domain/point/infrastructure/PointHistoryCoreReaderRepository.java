package com.hhplus.task.domain.point.infrastructure;

import com.hhplus.task.domain.point.component.UserPointModifier;
import com.hhplus.task.domain.point.models.UserPoint;
import com.hhplus.task.domain.point.repositories.PointHistoryReaderRepository;
import jakarta.persistence.Access;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@RequiredArgsConstructor
public class PointHistoryCoreReaderRepository implements PointHistoryReaderRepository {

    PointHistoryJpaRepository jpaRepository;
}
