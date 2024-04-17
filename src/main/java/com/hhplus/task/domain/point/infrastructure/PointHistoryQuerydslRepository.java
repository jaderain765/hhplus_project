package com.hhplus.task.domain.point.infrastructure;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PointHistoryQuerydslRepository {

    private final JPAQueryFactory jpaQueryFactory;


}
