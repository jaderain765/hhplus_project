package com.hhplus.task.api.concert.usecase;

import com.hhplus.task.domain.token.component.TokenReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GetTurnNumberUseCase {
    private final TokenReader tokenReader;

    public Long execute(String token){
        return tokenReader.getTurnNumber(token);
    }
}
