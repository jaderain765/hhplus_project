package com.hhplus.task.domain.concert.models;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Concert {
    private Long id;
    private String name;
    private Long charge;
    private Integer capacity;
    private LocalDateTime concertDate;
    private LocalDateTime updateTime;

    @Builder
    public Concert(Long id, String name, Long charge, Integer capacity, LocalDateTime concertDate, LocalDateTime updateTime) {
        this.id = id;
        this.name = name;
        this.charge = charge;
        this.capacity = capacity;
        this.concertDate = concertDate;
        this.updateTime = updateTime;
    }
}
