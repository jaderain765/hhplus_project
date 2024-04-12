package com.hhplus.task.domain.token.repositories;

import com.hhplus.task.domain.token.models.Token;

import java.util.List;

public interface TokenReaderRepository {

    Token findById(String id);

    Long findTurnNumberByToken(String token);

    public Long authorityTokenCount();

    public List<String> findGiveAuthorityList(long limit);

}
