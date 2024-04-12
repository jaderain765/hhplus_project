package com.hhplus.task.api.point.usecase;

import com.hhplus.task.api.point.dto.PointChangeDto;
import com.hhplus.task.domain.point.component.UserPointModifier;
import com.hhplus.task.exception.CustomRuntimeException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ChangePointUseCase {

    private UserPointModifier userPointModifier;

    public Long execute(PointChangeDto pointChangeDto) {
        if(pointChangeDto.getUserId() == null || pointChangeDto.getUserId() < 0L)
            throw new CustomRuntimeException("사용자 정보를 찾을 수 없습니다.");

        if(pointChangeDto.getAmount() == null || pointChangeDto.getAmount() < 0L)
            throw new CustomRuntimeException("충전에 실패하였습니다.");

        return userPointModifier.charge(pointChangeDto.getUserId(), pointChangeDto.getAmount());
    }
}
