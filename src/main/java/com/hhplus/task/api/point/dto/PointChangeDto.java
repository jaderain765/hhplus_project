package com.hhplus.task.api.point.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PointChangeDto {
    private Long userId;
    private Long amount;

    @Builder
    public PointChangeDto(Long userId, Long amount) {
        this.userId = userId;
        this.amount = amount;
    }
}
