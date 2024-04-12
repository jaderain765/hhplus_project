package com.hhplus.task.domain.concert.repositories;

import com.hhplus.task.domain.concert.models.Concert;
import com.hhplus.task.domain.concert.models.ConcertApplyHistory;

import java.util.List;
import java.util.Map;

public interface ConcertReaderRepository {

    Concert findById(Long id);

    List<Concert> findAll();

    /**
     * 사용(등록)가능한 콘서트 목록
     *
     * @return
     */
    List<Concert> findAllAbailable();

    /**
     * concertId 를 통해 해당 콘서트가 신청가능한지 알아보고 반환한다.
     *
     * @param id
     * @return
     */
    boolean isAbailableById(Long id);
}
