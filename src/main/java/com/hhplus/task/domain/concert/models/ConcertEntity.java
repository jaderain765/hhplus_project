package com.hhplus.task.domain.concert.models;

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

    private Long charge;

    private Integer capacity;

    private LocalDateTime concertDate;

    @LastModifiedDate
    private LocalDateTime updateTime;

    public ConcertEntity(Concert concert) {
        this.id = concert.getId();
        this.name = concert.getName();
        this.charge = concert.getCharge();
        this.capacity = concert.getCapacity();
        this.concertDate = concert.getConcertDate();
        this.updateTime = concert.getUpdateTime();
    }

    public Concert toConcert(){
        return Concert.builder()
                .id(this.id)
                .name(this.name)
                .charge(this.charge)
                .capacity(this.capacity)
                .concertDate(this.concertDate)
                .updateTime(this.updateTime)
                .build();
    }

    @Builder
    public ConcertEntity(Long id, String name, Long charge, Integer capacity, LocalDateTime concertDate, LocalDateTime updateTime) {
        this.id = id;
        this.name = name;
        this.charge = charge;
        this.capacity = capacity;
        this.concertDate = concertDate;
        this.updateTime = updateTime;
    }
}
