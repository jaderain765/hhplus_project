package com.hhplus.task.domain.token.infrastructure;

import com.hhplus.task.domain.token.repositories.TokenStoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class TokenCoreStoreRepository implements TokenStoreRepository {

    private TokenJpaRepository tokenJpaRepository;

    private TokenQuerydslRepository tokenQuerydslRepository;

    @Override
    public void deleteById(String tokenUUID) {
        tokenJpaRepository.deleteById(tokenUUID);
    }

    @Override
    public Long expiredTokenDelete() {
        return tokenQuerydslRepository.expiredTokenDelete();
    }

    @Override
    public Long tokenGiveAuthority(List<String> tokenList) {
        return tokenQuerydslRepository.tokenGiveAuthority(tokenList);
    }
}
