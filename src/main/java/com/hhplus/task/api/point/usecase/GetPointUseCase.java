package com.hhplus.task.api.point.usecase;

import com.hhplus.task.domain.point.component.UserPointReader;
import com.hhplus.task.domain.point.models.UserPoint;
import com.hhplus.task.exception.CustomRuntimeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GetPointUseCase {

    private UserPointReader userPointReader;

    public Long execute(Long userId){

        if(userId == null || userId < 0L) throw new CustomRuntimeException("사용자 정보를 찾을 수 없습니다.");

        UserPoint userPoint = userPointReader.getUserPoint(userId);

        if(userPoint == null) throw new CustomRuntimeException("사용자 정보를 찾을 수 없습니다.");

        return userPoint.getPoint();
    }
}
