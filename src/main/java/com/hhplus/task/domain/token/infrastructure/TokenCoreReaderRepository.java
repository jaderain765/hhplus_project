package com.hhplus.task.domain.token.infrastructure;

import com.hhplus.task.domain.token.models.Token;
import com.hhplus.task.domain.token.models.TokenEntity;
import com.hhplus.task.domain.token.repositories.TokenReaderRepository;
import com.hhplus.task.exception.CustomRuntimeException;

import java.util.List;
import java.util.Optional;

public class TokenCoreReaderRepository implements TokenReaderRepository {

    TokenQuerydslRepository tokenQuerydslRepository;

    TokenJpaRepository tokenJpaRepository;


    @Override
    public Token findById(String id) {
        Optional<TokenEntity> token = tokenJpaRepository.findById(id);

        if(token.isPresent()) return token.get().toToken();

        throw new CustomRuntimeException("토큰 정보가 없습니다.");
    }

    @Override
    public Long findTurnNumberByToken(String token) {
        return tokenQuerydslRepository.getTurnNumber(token);
    }

    @Override
    public Long authorityTokenCount() {
        return tokenQuerydslRepository.authorityTokenCount();
    }

    @Override
    public List<String> findGiveAuthorityList(long limit) {
        return tokenQuerydslRepository.findGiveAuthorityList(limit);
    }
}
