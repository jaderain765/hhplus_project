package com.hhplus.task.api.concert.usecase;

import com.hhplus.task.domain.token.component.TokenReader;
import lombok.RequiredArgsConstructor;

public class GetTurnNumberUseCase {
    private static TokenReader tokenReader;

    public GetTurnNumberUseCase(TokenReader tokenReader) {
        this.tokenReader = tokenReader;
    }

    public Long execute(String token){
        return tokenReader.getTurnNumber(token);
    }
}
