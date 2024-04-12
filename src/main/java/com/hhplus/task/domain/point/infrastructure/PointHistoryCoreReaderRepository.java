package com.hhplus.task.domain.point.infrastructure;

import com.hhplus.task.domain.point.repositories.PointHistoryReaderRepository;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class PointHistoryCoreReaderRepository implements PointHistoryReaderRepository {

    PointHistoryJpaRepository jpaRepository;
}
