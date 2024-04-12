package com.hhplus.task.config;

import com.hhplus.task.domain.concert.models.Concert;

import java.util.ArrayList;
import java.util.List;


public class TestTable {
    private static final List<Concert> CONCERT_LIST = new ArrayList<>();

    public static List<Concert> getConcertList(){
        return CONCERT_LIST;
    }
}
