package com.hhplus.task.domain.concert.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "CONCERT_APPLY_HISTORY")
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
@IdClass(value = ConcertApplyHistoryPK.class)
@ToString
public class ConcertApplyHistoryEntity {

    @Id
    private Integer seatNumber;

    @Id
    private Long concertId;

    private Long userId;

    private LocalDateTime reservationTime;

    private LocalDateTime paymentTime;

    @LastModifiedDate
    private LocalDateTime updateTime;

    public ConcertApplyHistory toConcertApplyHistory(){
        return ConcertApplyHistory.builder()
                .seatNumber(this.seatNumber)
                .concertId(this.concertId)
                .userId(this.userId)
                .reservationTime(this.reservationTime)
                .paymentTime(this.paymentTime)
                .updateTime(this.updateTime)
                .build();
    }

    public ConcertApplyHistoryEntity(ConcertApplyHistory concertApplyHistory) {
        this.seatNumber = concertApplyHistory.getSeatNumber();
        this.concertId = concertApplyHistory.getConcertId();
        this.userId = concertApplyHistory.getUserId();
        this.reservationTime = concertApplyHistory.getReservationTime();
        this.paymentTime = concertApplyHistory.getPaymentTime();
        this.updateTime = concertApplyHistory.getUpdateTime();
    }

    @Builder
    public ConcertApplyHistoryEntity(Integer seatNumber, Long concertId, Long userId, LocalDateTime reservationTime, LocalDateTime paymentTime, LocalDateTime updateTime) {
        this.seatNumber = seatNumber;
        this.concertId = concertId;
        this.userId = userId;
        this.reservationTime = reservationTime;
        this.paymentTime = paymentTime;
        this.updateTime = updateTime;
    }
}
