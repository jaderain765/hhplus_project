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
@Table(name = "USER_POINT")
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
@ToString
public class UserPointEntity {
    @Id
    private Long userId;
    private Long point;

    @LastModifiedDate
    private LocalDateTime updateTime;

    @Builder
    public UserPointEntity(Long userId, Long point, LocalDateTime updateTime) {
        this.userId = userId;
        this.point = point;
        this.updateTime = updateTime;
    }

    public UserPointEntity(UserPoint userPoint) {
        this.userId = userPoint.getUserId();
        this.point = userPoint.getPoint();
        this.updateTime = userPoint.getUpdateTime();
    }

    public UserPoint toUserPoint(){
        return UserPoint.builder()
                .userId(this.userId)
                .point(this.point)
                .updateTime(this.updateTime)
                .build();
    }
}
