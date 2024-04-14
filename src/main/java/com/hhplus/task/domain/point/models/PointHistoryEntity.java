package com.hhplus.task.domain.point.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "POINT_HISTORY")
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@EntityListeners(AuditingEntityListener.class)
public class PointHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long seq;

    private Long point;

    private Long amount;

    private PointStatus type;

    @CreatedDate
    private LocalDateTime createTime;

    @Builder
    public PointHistoryEntity(Long seq, Long point, Long amount, PointStatus type, LocalDateTime createTime) {
        this.seq = seq;
        this.point = point;
        this.amount = amount;
        this.type = type;
        this.createTime = createTime;
    }

    public PointHistoryEntity(PointHistory pointHistory) {
        this.seq = pointHistory.getSeq();
        this.point = pointHistory.getPoint();
        this.amount = pointHistory.getAmount();
        this.type = pointHistory.getType();
        this.createTime = pointHistory.getCreateTime();
    }

    public PointHistory toPointHistory(){
        return PointHistory.builder()
                .seq(this.seq)
                .point(this.point)
                .amount(this.amount)
                .type(this.type)
                .createTime(this.createTime)
                .build();
    }
}
