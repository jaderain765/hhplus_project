package com.hhplus.task.domain.token.component;

import com.hhplus.task.domain.token.repositories.TokenReaderRepository;
import com.hhplus.task.exception.CustomRuntimeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class TokenReader {

    private TokenReaderRepository readerRepository;

    public boolean isUseable(String token){

        LocalDateTime vaildTime = readerRepository.findById(token).getValidTime();

        if(vaildTime == null) throw new CustomRuntimeException("대기 중인 토큰입니다.");

        return vaildTime.isBefore(LocalDateTime.now());
    }

    public Long getTurnNumber(String token){
        return readerRepository.findTurnNumberByToken(token);
    }
}
