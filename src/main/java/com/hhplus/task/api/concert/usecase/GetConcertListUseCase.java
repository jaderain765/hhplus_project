package com.hhplus.task.api.concert.usecase;

import com.hhplus.task.domain.concert.component.ConcertReader;
import com.hhplus.task.domain.concert.models.Concert;

import java.util.List;

public class GetConcertListUseCase {
    private ConcertReader concertReader;

    public GetConcertListUseCase(ConcertReader concertReader) {
        this.concertReader = concertReader;
    }

    public List<Concert> execute(){
        return concertReader.findAll();
    }
}
