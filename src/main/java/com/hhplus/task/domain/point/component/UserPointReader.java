package com.hhplus.task.domain.point.component;

import com.hhplus.task.domain.point.infrastructure.UserPointCoreReaderRepository;
import com.hhplus.task.domain.point.models.UserPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserPointReader {

    private UserPointCoreReaderRepository userPointCoreReaderRepository;

    public UserPoint getUserPoint(Long userId){
        return userPointCoreReaderRepository.findUserPointById(userId);
    }
}
