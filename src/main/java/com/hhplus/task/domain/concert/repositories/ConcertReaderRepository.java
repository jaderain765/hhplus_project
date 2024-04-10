package com.hhplus.task.domain.concert.repositories;

import com.hhplus.task.domain.concert.models.ConcertEntity;

import java.util.List;

public interface ConcertReaderRepository {

    List<ConcertEntity> findAll();
}
