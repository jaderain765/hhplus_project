package com.hhplus.task.api.point.dto;

import com.hhplus.task.domain.point.models.PointStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class PointChangeDto {
    private Long userId;
    private Long amount;
    private PointStatus pointStatus;
}
