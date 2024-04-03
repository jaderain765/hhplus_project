package com.hhplus.task.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public enum PointStatus {
    USE("use"), CHARGE("charge");

    private String value;
}
