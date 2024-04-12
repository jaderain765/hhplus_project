package com.hhplus.task.domain.point.infrastructure;

import com.hhplus.task.domain.point.models.*;
import com.hhplus.task.domain.point.repositories.UserPointStoreRepository;
import com.hhplus.task.exception.CustomRuntimeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserPointCoreStoreRepository implements UserPointStoreRepository {

    private UserPointJpaRepository userPointJpaRepository;

    private PointHistoryJpaRepository pointHistoryJpaRepository;

    @Override
    public Long pointUpdate(Long userId, Long amount, PointStatus type) {
        Optional<UserPointEntity> userPointEntityOptional = userPointJpaRepository.findById(userId);

        if(userPointEntityOptional.isEmpty()) throw new CustomRuntimeException("사용자 정보를 찾을 수 없습니다.");

        UserPoint userPoint = userPointEntityOptional.get().toUserPoint();

        Long pointChargeResult = getPointResult(amount, type, userPoint);

        UserPoint updateUserPoint = UserPoint.builder()
                .userId(userPoint.getUserId())
                .point(pointChargeResult)
                .build();

        userPointJpaRepository.save(new UserPointEntity(updateUserPoint));

        PointHistory pointHistory = PointHistory.builder()
                .point(pointChargeResult)
                .amount(amount)
                .type(PointStatus.CHARGE)
                .build();

        pointHistoryJpaRepository.save(new PointHistoryEntity(pointHistory));

        return pointChargeResult;
    }

    private static Long getPointResult(Long amount, PointStatus type, UserPoint userPoint) {
        Long pointChargeResult;

        if(type == PointStatus.USE){
            pointChargeResult = userPoint.getPoint() - amount;

            if(amount > userPoint.getPoint())
                throw new CustomRuntimeException("포인트가 모자랍니다.");
        }else {
            pointChargeResult = userPoint.getPoint() + amount;

            // 더했지만, 값이 작아짐 (오버플로우 현상)
            if(pointChargeResult < amount || pointChargeResult < userPoint.getPoint())
                throw new CustomRuntimeException("충전 금액 한도 초과입니다.");
        }
        return pointChargeResult;
    }
}
