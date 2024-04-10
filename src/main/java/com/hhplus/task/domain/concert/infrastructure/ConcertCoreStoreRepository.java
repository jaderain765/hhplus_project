package com.hhplus.task.domain.concert.infrastructure;

import com.hhplus.task.domain.concert.models.ConcertEntity;
import com.hhplus.task.domain.concert.repositories.ConcertReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@RequiredArgsConstructor
@Repository
public class ConcertCoreStoreRepository implements ConcertReaderRepository {

    private ConcertJpaRepository concertJpaRepository;

    @Override
    public List<ConcertEntity> findAll() {
        return concertJpaRepository.findAll();
    }
}
