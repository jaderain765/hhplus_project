package com.hhplus.task.domain.concert.models;

import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ConcertApplyHistoryPK implements Serializable {

    private Integer seatNumber;
    private Long concertId;

    @Builder
    public ConcertApplyHistoryPK(Integer seatNumber, Long concertId) {
        this.seatNumber = seatNumber;
        this.concertId = concertId;
    }
}
