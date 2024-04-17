package com.hhplus.task.api.concert.usecase;

import com.hhplus.task.api.concert.dto.ConcertRequestDto;
import com.hhplus.task.domain.concert.component.ConcertModifier;
import com.hhplus.task.domain.concert.component.ConcertReader;
import com.hhplus.task.domain.concert.models.Concert;
import com.hhplus.task.domain.concert.models.ConcertApplyHistory;
import com.hhplus.task.domain.point.component.UserPointModifier;
import com.hhplus.task.domain.point.component.UserPointReader;
import com.hhplus.task.domain.point.models.UserPoint;
import com.hhplus.task.exception.CustomRuntimeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PayConcertUseCase {

    private final ConcertReader concertReader;
    private final ConcertModifier concertModifier;
    private final UserPointReader userPointReader;
    private final UserPointModifier userPointModifier;

    public ConcertApplyHistory execute(ConcertRequestDto concertRequestDto){

        Concert concert = concertReader.findConcert(concertRequestDto.getConcertId());
        if(concert == null) throw new CustomRuntimeException("공연 정보를 찾을 수 없습니다.");

        UserPoint userPoint = userPointReader.getUserPoint(concertRequestDto.getUserId());
        if(userPoint == null) throw new CustomRuntimeException("사용자 정보를 찾을 수 없습니다.");

        if(concert.getCharge() > userPoint.getPoint())
            throw new CustomRuntimeException("보유하신 포인트가 부족합니다.");

        userPointModifier.use(userPoint.getUserId(), concert.getCharge());

        return concertModifier.payConcert(
                concertRequestDto.getConcertId(),
                concertRequestDto.getSeatNumber(),
                concertRequestDto.getUserId()
        );
    }
}
