package com.hhplus.task.api.concert.dto;

import com.hhplus.task.domain.concert.component.ConcertReader;
import com.hhplus.task.exception.CustomRuntimeException;
import lombok.*;

@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ConcertRequestDto {
    private Long concertId; // 콘서트 아이디
    private Integer seatNumber; // 좌석번호
    private Long userId; // 사용자 아이디

    @Builder
    public ConcertRequestDto(Long concertId, Integer seatNumber, Long userId) {
        this.concertId = concertId;
        this.seatNumber = seatNumber;
        this.userId = userId;
    }

    public void valid(){
        if(concertId == null || concertId < 1)
            throw new CustomRuntimeException("콘서트 정보를 찾을 수 없습니다.");

        int capacity = new ConcertReader().findCapacityById(concertId);

        if(seatNumber == null || seatNumber < 1 || seatNumber > capacity)
            throw new CustomRuntimeException("요청하신 좌석 정보가 잘못되었습니다.");

        if(userId == null || userId < 1L)
            throw new CustomRuntimeException("사용자 정보를 찾을 수 없습니다.");
    }
}
