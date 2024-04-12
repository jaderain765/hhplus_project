package com.hhplus.task.stub;

import com.hhplus.task.domain.token.models.Token;
import com.hhplus.task.domain.token.repositories.TokenReaderRepository;

import java.util.List;

public class TokenReaderRepositoryStub implements TokenReaderRepository {
    @Override
    public Token findById(String id) {
        return null;
    }

    @Override
    public Long findTurnNumberByToken(String token) {
        return null;
    }

    @Override
    public Long authorityTokenCount() {
        return null;
    }

    @Override
    public List<String> findGiveAuthorityList(long limit) {
        return null;
    }
}
