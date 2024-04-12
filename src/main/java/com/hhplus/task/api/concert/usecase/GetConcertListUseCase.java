package com.hhplus.task.api.concert.usecase;

import com.hhplus.task.domain.concert.component.ConcertReader;
import com.hhplus.task.domain.concert.models.Concert;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetConcertListUseCase {
    private ConcertReader concertReader;

    public List<Concert> execute(){
        return concertReader.findAll();
    }
}
