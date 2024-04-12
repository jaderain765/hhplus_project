package com.hhplus.task.domain.point.repositories;

import com.hhplus.task.domain.point.models.PointStatus;

public interface UserPointStoreRepository {

    public Long pointUpdate(Long userId, Long amount, PointStatus type);
}
