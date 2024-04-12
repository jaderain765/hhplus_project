package com.hhplus.task.domain.point.models;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class UserPoint {
    private Long userId;
    private Long point;
    private LocalDateTime updateTime;

    @Builder
    public UserPoint(Long userId, Long point, LocalDateTime updateTime) {
        this.userId = userId;
        this.point = point;
        this.updateTime = updateTime;
    }
}
