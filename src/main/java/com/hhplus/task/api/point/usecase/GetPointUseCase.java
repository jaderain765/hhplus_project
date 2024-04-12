package com.hhplus.task.api.point.usecase;

import com.hhplus.task.domain.point.component.UserPointReader;
import com.hhplus.task.exception.CustomRuntimeException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetPointUseCase {

    private UserPointReader userPointReader;

    public Long execute(Long userId){

        if(userId == null || userId < 0L) throw new CustomRuntimeException("사용자 정보를 찾을 수 없습니다.");

        return userPointReader.getUserPoint(userId).getPoint();
    }
}
