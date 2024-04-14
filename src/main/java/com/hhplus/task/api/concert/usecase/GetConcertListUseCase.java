package com.hhplus.task.api.concert.usecase;

import com.hhplus.task.domain.concert.component.ConcertReader;
import com.hhplus.task.domain.concert.models.Concert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class GetConcertListUseCase {

    private final ConcertReader concertReader;

    public List<Concert> execute(boolean isAll){
        return isAll ? concertReader.findAll() : concertReader.findAllAvailable();
    }
}
