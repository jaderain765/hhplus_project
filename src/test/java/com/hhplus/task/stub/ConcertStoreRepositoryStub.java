package com.hhplus.task.stub;

import com.hhplus.task.config.TestTable;
import com.hhplus.task.domain.concert.models.Concert;
import com.hhplus.task.domain.concert.repositories.ConcertStoreRepository;

import java.util.List;

public class ConcertStoreRepositoryStub implements ConcertStoreRepository {

    private static final List<Concert> concertStore = TestTable.getConcertList();

    public Concert save(Concert concert){
        concertStore.add(concert);
        return concert;
    }

    public void clear(){
        concertStore.clear();
    }
}
