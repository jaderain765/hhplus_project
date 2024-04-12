package com.hhplus.task.api.concert.usecase;

import com.hhplus.task.domain.token.component.TokenReader;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetTurnNumberUseCase {
    private TokenReader tokenReader;


    public Long execute(String token){
        return tokenReader.getTurnNumber(token);
    }
}
