package com.hhplus.task.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "CONCERT")
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
@ToString
public class ConcertEntity {

    @Id
    private Long id;

    private String name;

    private Integer charge;

    private Integer capacity;

    private LocalDateTime concertDate;

    @LastModifiedDate
    private LocalDateTime updateTime;

    @Builder
    public ConcertEntity(Long id, String name, Integer charge, Integer capacity, LocalDateTime concertDate, LocalDateTime updateTime) {
        this.id = id;
        this.name = name;
        this.charge = charge;
        this.capacity = capacity;
        this.concertDate = concertDate;
        this.updateTime = updateTime;
    }
}
