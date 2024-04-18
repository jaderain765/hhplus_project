package com.hhplus.task.config;

import com.hhplus.task.domain.concert.models.Concert;
import com.hhplus.task.domain.token.models.Token;

import java.util.ArrayList;
import java.util.List;


public class TestTable {
    private static final List<Concert> CONCERT_LIST = new ArrayList<>();
    private static final List<Token> TOKEN_LIST = new ArrayList<>();

    public static List<Concert> getConcertList(){
        return CONCERT_LIST;
    }
    public static List<Token> getTokenList(){
        return TOKEN_LIST;
    }
}
