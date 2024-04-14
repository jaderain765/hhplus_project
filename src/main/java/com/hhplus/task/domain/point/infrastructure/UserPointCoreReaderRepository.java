package com.hhplus.task.domain.point.infrastructure;

import com.hhplus.task.domain.point.models.UserPoint;
import com.hhplus.task.domain.point.models.UserPointEntity;
import com.hhplus.task.domain.point.repositories.UserPointReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserPointCoreReaderRepository implements UserPointReaderRepository {

    private UserPointJpaRepository userPointJpaRepository;

    @Override
    public UserPoint findUserPointById(Long userId) {
        Optional<UserPointEntity> userPointEntity = userPointJpaRepository.findById(userId);

        return userPointEntity.isPresent() ? userPointEntity.get().toUserPoint() : null;
    }
}
