package com.hhplus.task.domain.concert.models;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ConcertApplyHistory {
    private Integer seatNumber;
    private Long concertId;
    private Long userId;
    private LocalDateTime reservationTime;
    private LocalDateTime paymentTime;
    private LocalDateTime updateTime;

    @Builder
    public ConcertApplyHistory(Integer seatNumber, Long concertId, Long userId, LocalDateTime reservationTime, LocalDateTime paymentTime, LocalDateTime updateTime) {
        this.seatNumber = seatNumber;
        this.concertId = concertId;
        this.userId = userId;
        this.reservationTime = reservationTime;
        this.paymentTime = paymentTime;
        this.updateTime = updateTime;
    }
}
