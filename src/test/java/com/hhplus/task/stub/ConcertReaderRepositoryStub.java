package com.hhplus.task.stub;

import com.hhplus.task.config.TestTable;
import com.hhplus.task.domain.concert.models.Concert;
import com.hhplus.task.domain.concert.repositories.ConcertReaderRepository;
import com.hhplus.task.exception.CustomRuntimeException;

import java.util.List;
import java.util.Optional;

public class ConcertReaderRepositoryStub implements ConcertReaderRepository {

    private static final List<Concert> concertStore = TestTable.getConcertList();

    @Override
    public Concert findById(Long id) {
        Optional<Concert> concert = concertStore.stream().filter(c -> c.getId().equals(id)).findFirst();
        
        if(concert.isPresent()) return concert.get();
        
        throw new CustomRuntimeException("테스트 익셉션 출력");
    }

    @Override
    public List<Concert> findAll() {
        return concertStore;
    }

    @Override
    public List<Concert> findAllAbailable() {
        return concertStore;
    }

    @Override
    public boolean isAbailableById(Long id) {
        return concertStore.stream().anyMatch(c -> c.getId().equals(id));
    }
}
