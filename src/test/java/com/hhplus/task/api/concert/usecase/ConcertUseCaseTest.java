package com.hhplus.task.api.concert.usecase;

import com.hhplus.task.api.concert.dto.ConcertRequestDto;
import com.hhplus.task.domain.concert.component.ConcertModifier;
import com.hhplus.task.domain.concert.component.ConcertReader;
import com.hhplus.task.domain.concert.models.Concert;
import com.hhplus.task.domain.concert.models.ConcertApplyHistory;
import com.hhplus.task.domain.concert.models.ConcertApplyHistoryPK;
import com.hhplus.task.domain.token.component.TokenReader;
import com.hhplus.task.stub.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
class ConcertUseCaseTest {

    private final GetConcertListUseCase getConcertListUseCase;
    private final GetTurnNumberUseCase getTurnNumberUseCase;
    private final ReserveConcertUseCase reserveConcertUseCase;

    private ConcertStoreRepositoryStub concertStoreRepository;

    private TokenStoreRepositoryStub tokenStoreRepository;

    private ConcertApplyHistoryCoreReaderRepositoryStub concertApplyHistoryCoreReaderRepository;

    public ConcertUseCaseTest() {
        ConcertReaderRepositoryStub concertReaderRepository = new ConcertReaderRepositoryStub();
        concertStoreRepository = new ConcertStoreRepositoryStub();
        TokenReaderRepositoryStub tokenReaderRepository = new TokenReaderRepositoryStub();
        tokenStoreRepository = new TokenStoreRepositoryStub();
        concertApplyHistoryCoreReaderRepository =
                new ConcertApplyHistoryCoreReaderRepositoryStub();
        ConcertApplyHistoryModifierRepositoryStub concertApplyHistoryModifierRepository =
                new ConcertApplyHistoryModifierRepositoryStub();

        ConcertReader concertReader = new ConcertReader(concertReaderRepository);
        TokenReader tokenReader = new TokenReader(tokenReaderRepository);
        ConcertModifier concertModifier = new ConcertModifier(
                concertApplyHistoryCoreReaderRepository,
                concertApplyHistoryModifierRepository
        );

        this.getConcertListUseCase = new GetConcertListUseCase(concertReader);
        this.getTurnNumberUseCase = new GetTurnNumberUseCase(tokenReader);
        this.reserveConcertUseCase = new ReserveConcertUseCase(concertModifier);
    }

    @BeforeEach
    void Before(){
        concertStoreRepository.clear();
    }

    @Test
    @DisplayName("콘서트_리스트를_가져오는_UseCase")
    void getConcertListUseCase() {
        // given
        LocalDateTime now1 = LocalDateTime.now();
        LocalDateTime now2 = LocalDateTime.now();

        for(long l = 1L; l <= 10L; l++){
            Concert concert = Concert.builder()
                    .id(l)
                    .name("공연 이름_" + l)
                    .charge(100000L)
                    .capacity(50)
                    .concertDate(now1)
                    .updateTime(now2)
                    .build();

            concertStoreRepository.save(concert);
        }

        // when
        List<Concert> concertList = getConcertListUseCase.execute(false);

        // then
        assertThat(concertList.size()).isEqualTo(10L);
    }

    @Test
    @DisplayName("대기열_순번_출력_UseCase")
    void getTurnNumberUseCase() {
        // given
        String token1 = tokenStoreRepository.createToken(1L);
        String token2 = tokenStoreRepository.createToken(2L);
        String token3 = tokenStoreRepository.createToken(3L);
        String token4 = tokenStoreRepository.createToken(4L);
        String token5 = tokenStoreRepository.createToken(5L);

        // when
        Long result1 = getTurnNumberUseCase.execute(token1);
        Long result2 = getTurnNumberUseCase.execute(token2);
        Long result3 = getTurnNumberUseCase.execute(token3);
        Long result4 = getTurnNumberUseCase.execute(token4);
        Long result5 = getTurnNumberUseCase.execute(token5);

        // then
        assertThat(result1).isEqualTo(1L);
        assertThat(result2).isEqualTo(2L);
        assertThat(result3).isEqualTo(3L);
        assertThat(result4).isEqualTo(4L);
        assertThat(result5).isEqualTo(5L);
    }

    @Test
    @DisplayName("콘서트_예약_UseCase")
    void reserveConcertUseCase() {
        // given
        ConcertRequestDto requestDto = ConcertRequestDto.builder()
                .concertId(1L)
                .seatNumber(1)
                .userId(1L)
                .build();

        // when
        reserveConcertUseCase.execute(requestDto);

        // then
        ConcertApplyHistory applyHistory =
                concertApplyHistoryCoreReaderRepository.findById(
                        ConcertApplyHistoryPK.builder()
                                .concertId(1L)
                                .seatNumber(1)
                                .build());


        assertThat(applyHistory.getConcertId()).isEqualTo(requestDto.getConcertId());
        assertThat(applyHistory.getSeatNumber()).isEqualTo(requestDto.getSeatNumber());
        assertThat(applyHistory.getUserId()).isEqualTo(requestDto.getUserId());
    }
    @Test
    @DisplayName("콘서트_결제_UseCase")
    void payConcertUseCase() {
        // given

        // when

        // then

    }
}