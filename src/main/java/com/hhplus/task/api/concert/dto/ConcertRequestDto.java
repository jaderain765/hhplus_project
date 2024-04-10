package com.hhplus.task.api.concert.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ConcertRequestDto {
    Integer seatNumber; // 좌석번호
    Long concertId; // 콘서트 아이디
    Long userId; // 사용자 아이디
}
