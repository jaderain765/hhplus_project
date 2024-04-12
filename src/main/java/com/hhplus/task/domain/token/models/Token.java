package com.hhplus.task.domain.token.models;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Token {
    private String tokenUUID;
    private Long userId;
    private LocalDateTime createTime;
    private LocalDateTime validTime;


    @Builder
    public Token(String tokenUUID, Long userId, LocalDateTime createTime, LocalDateTime validTime) {
        this.tokenUUID = tokenUUID;
        this.userId = userId;
        this.createTime = createTime;
        this.validTime = validTime;
    }
}
