package com.hhplus.task.domain.point.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "POINT_HISTORY")
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@EntityListeners(AuditingEntityListener.class)
public class PointHistory {

    @Id
    private Long seq;

    private Long amount;

    private PointStatus type;

    @LastModifiedDate
    private LocalDateTime createTime;

    @Builder
    public PointHistory(Long seq, Long amount, PointStatus type, LocalDateTime createTime) {
        this.seq = seq;
        this.amount = amount;
        this.type = type;
        this.createTime = createTime;
    }
}
