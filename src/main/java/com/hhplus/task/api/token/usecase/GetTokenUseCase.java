package com.hhplus.task.api.token.usecase;

import com.hhplus.task.domain.token.component.TokenModifier;

public class GetTokenUseCase {

    TokenModifier tokenModifier;

    public String execute(Long userId) {
        return tokenModifier.createToken(userId);
    }
}
