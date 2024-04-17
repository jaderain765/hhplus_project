package com.hhplus.task.api.token.usecase;

import com.hhplus.task.domain.token.component.TokenModifier;
import com.hhplus.task.exception.CustomRuntimeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GetTokenUseCase {

    private final TokenModifier tokenModifier;

    public String execute(Long userId) {
        if(userId == null || userId < 0L) throw new CustomRuntimeException("사용자 정보를 찾을 수 없습니다.");
        return tokenModifier.createToken(userId);
    }
}
