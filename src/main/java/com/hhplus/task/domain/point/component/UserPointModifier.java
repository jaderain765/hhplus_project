package com.hhplus.task.domain.point.component;

import com.hhplus.task.domain.point.models.PointStatus;
import com.hhplus.task.domain.point.repositories.UserPointStoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserPointModifier {

    private UserPointStoreRepository userPointStoreRepository;

    public Long use(Long userId, Long amount){
        return userPointStoreRepository.pointUpdate(userId, amount, PointStatus.USE);
    }

    public Long charge(Long userId, Long amount){
        return userPointStoreRepository.pointUpdate(userId, amount, PointStatus.CHARGE);
    }
}
