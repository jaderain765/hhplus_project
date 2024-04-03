package com.hhplus.task.entity;

import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ConcertApplyHistoryPK implements Serializable {

    private Integer seatNumber;
    private Long concertId;
}
