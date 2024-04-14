package com.hhplus.task.domain.point.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PointStatus {
    USE("use"), CHARGE("charge");

    private String value;
}
