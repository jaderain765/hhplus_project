package com.hhplus.task.domain.token.infrastructure;

import com.hhplus.task.domain.token.models.Token;
import com.hhplus.task.domain.token.models.TokenEntity;
import com.hhplus.task.domain.token.repositories.TokenReaderRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TokenCoreReaderRepository implements TokenReaderRepository {

    TokenQuerydslRepository tokenQuerydslRepository;

    TokenJpaRepository tokenJpaRepository;


    @Override
    public Token findById(String id) {
        TokenEntity token = tokenJpaRepository.findById(id).orElse(null);

        return token == null ? null : token.toToken();
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
