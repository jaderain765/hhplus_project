package com.hhplus.task.stub;

import com.hhplus.task.config.TestTable;
import com.hhplus.task.domain.concert.models.Concert;
import com.hhplus.task.domain.token.models.Token;
import com.hhplus.task.domain.token.repositories.TokenReaderRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TokenReaderRepositoryStub implements TokenReaderRepository {

    private static final List<Token> tokenList = TestTable.getTokenList();

    @Override
    public Token findById(String id) {
        return tokenList.stream().filter(token -> token.getTokenUUID().equals(id)).findAny().orElse(null);
    }

    @Override
    public Long findTurnNumberByToken(String token) {
        long turnNumber = 1L;

        for(Token t : tokenList){
            if(t.getTokenUUID().equals(token)) return turnNumber;

            turnNumber++;
        }

        return null;
    }

    @Override
    public Long authorityTokenCount() {
        LocalDateTime now = LocalDateTime.now();
        return tokenList
                .stream()
                .filter(t -> t.getValidTime().isAfter(now.plusMinutes(5)))
                .count();
    }

    @Override
    public List<String> findGiveAuthorityList(long limit) {
        List<Token> tokens = tokenList.stream().filter(t -> t.getValidTime() == null).toList();

        if(tokens.size() == 0) return null;

        List<String> result = new ArrayList<>();

        for(Token t : tokens){
            if(limit-- == 0) break;

            result.add(t.getTokenUUID());
        }

        return result;
    }
}
