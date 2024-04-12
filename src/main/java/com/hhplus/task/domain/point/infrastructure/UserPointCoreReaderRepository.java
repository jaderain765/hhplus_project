package com.hhplus.task.domain.point.infrastructure;

import com.hhplus.task.domain.point.models.UserPoint;
import com.hhplus.task.domain.point.models.UserPointEntity;
import com.hhplus.task.domain.point.repositories.UserPointReaderRepository;
import com.hhplus.task.exception.CustomRuntimeException;
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

        if(userPointEntity.isPresent()) return userPointEntity.get().toUserPoint();

        throw new CustomRuntimeException("사용자 정보를 찾을 수 없습니다.");
    }
}
