package com.hhplus.task.domain.token.repositories;

import java.util.List;

public interface TokenStoreRepository {
    void deleteById(String tokenUUID);

    public Long expiredTokenDelete();

    public Long tokenGiveAuthority(List<String> tokenList);

    String createToken(Long userId);
}
