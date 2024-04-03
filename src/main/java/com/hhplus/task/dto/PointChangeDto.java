package com.hhplus.task.dto;

import com.hhplus.task.entity.PointStatus;
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
