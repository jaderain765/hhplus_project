package com.hhplus.task.domain.point.repositories;

import com.hhplus.task.domain.point.models.UserPoint;

public interface UserPointReaderRepository {
    UserPoint findUserPointById(Long userId);
}
