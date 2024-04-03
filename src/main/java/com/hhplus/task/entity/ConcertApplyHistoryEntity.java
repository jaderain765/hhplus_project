package com.hhplus.task.entity;

import jakarta.persistence.*;
import lombok.*;
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

    private Integer capacity;

    private LocalDateTime reservationTime;

    private LocalDateTime paymentTime;

    @LastModifiedDate
    private LocalDateTime updateTime;

    @Builder
    public ConcertApplyHistoryEntity(Integer seatNumber, Long concertId, Long userId, Integer capacity, LocalDateTime reservationTime, LocalDateTime paymentTime, LocalDateTime updateTime) {
        this.seatNumber = seatNumber;
        this.concertId = concertId;
        this.userId = userId;
        this.capacity = capacity;
        this.reservationTime = reservationTime;
        this.paymentTime = paymentTime;
        this.updateTime = updateTime;
    }
}
