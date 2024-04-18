package com.hhplus.task.stub;

import com.hhplus.task.config.TestTable;
import com.hhplus.task.domain.token.models.Token;
import com.hhplus.task.domain.token.repositories.TokenStoreRepository;
import net.bytebuddy.asm.Advice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class TokenStoreRepositoryStub implements TokenStoreRepository {

    private static final List<Token> tokenList = TestTable.getTokenList();

    @Override
    public void deleteById(String tokenUUID) {

    }

    @Override
    public Long expiredTokenDelete() {
        return null;
    }

    @Override
    public Long tokenGiveAuthority(List<String> tokenList) {
        return null;
    }

    @Override
    public String createToken(Long userId) {

        Token token = Token.builder()
                .tokenUUID(UUID.randomUUID().toString())
                .userId(userId)
                .createTime(LocalDateTime.now())
                .build();

        tokenList.add(token);

        return token.getTokenUUID();
    }
}
