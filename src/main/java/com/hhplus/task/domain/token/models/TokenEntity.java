package com.hhplus.task.domain.token.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "TOKEN")
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@EntityListeners(AuditingEntityListener.class)
public class TokenEntity {
    @Id
    private String tokenUUID;

    private Long userId;

    @CreatedDate
    private LocalDateTime createTime;

    private LocalDateTime validTime;

    public TokenEntity(Token token) {
        this.tokenUUID = token.getTokenUUID();
        this.userId = token.getUserId();
        this.createTime = token.getCreateTime();
        this.validTime = token.getValidTime();
    }

    public Token toToken(){
        return Token.builder()
                .tokenUUID(this.tokenUUID)
                .userId(this.userId)
                .createTime(this.createTime)
                .validTime(this.validTime)
                .build();
    }

    @Builder
    public TokenEntity(String tokenUUID, Long userId, LocalDateTime createTime, LocalDateTime validTime) {
        this.tokenUUID = tokenUUID;
        this.userId = userId;
        this.createTime = createTime;
        this.validTime = validTime;
    }
}
