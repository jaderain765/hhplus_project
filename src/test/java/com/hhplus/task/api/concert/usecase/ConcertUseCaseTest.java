package com.hhplus.task.api.concert.usecase;

import com.hhplus.task.domain.concert.component.ConcertReader;
import com.hhplus.task.stub.ConcertReaderRepositoryStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

@Transactional
class ConcertUseCaseTest {

    private final GetConcertListUseCase getConcertListUseCase;

    public ConcertUseCaseTest() {
        ConcertReaderRepositoryStub concertReaderRepository = new ConcertReaderRepositoryStub();

        ConcertReader concertReader = new ConcertReader(concertReaderRepository);

        this.getConcertListUseCase = new GetConcertListUseCase(concertReader);
    }

    @Test
    @DisplayName("콘서트_리스트를_가져오는_UseCase")
    void getConcertListUseCase() {
        // given

        // when
        getConcertListUseCase.execute(false);

        // then

    }

    @Test
    @DisplayName("대기열_순번_출력_UseCase")
    void getTurnNumberUseCase() {
        // given

        // when

        // then

    }

    @Test
    @DisplayName("콘서트_예약_UseCase")
    void reserveConcertUseCase() {
        // given

        // when

        // then

    }
    @Test
    @DisplayName("콘서트_결제_UseCase")
    void payConcertUseCase() {
        // given

        // when

        // then

    }
}