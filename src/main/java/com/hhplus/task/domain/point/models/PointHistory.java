package com.hhplus.task.domain.point.models;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PointHistory {
    private Long seq;
    private Long point;
    private Long amount;
    private PointStatus type;
    private LocalDateTime createTime;

    @Builder
    public PointHistory(Long seq, Long point, Long amount, PointStatus type, LocalDateTime createTime) {
        this.seq = seq;
        this.point = point;
        this.amount = amount;
        this.type = type;
        this.createTime = createTime;
    }
}
