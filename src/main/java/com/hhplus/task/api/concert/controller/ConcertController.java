package com.hhplus.task.api.concert.controller;

import com.hhplus.task.annotation.AccessTokenValue;
import com.hhplus.task.annotation.CheckToken;
import com.hhplus.task.api.concert.dto.ConcertRequestDto;
import com.hhplus.task.api.concert.usecase.GetConcertListUseCase;
import com.hhplus.task.api.concert.usecase.GetTurnNumberUseCase;
import com.hhplus.task.api.concert.usecase.PayConcertUseCase;
import com.hhplus.task.api.concert.usecase.ReserveConcertUseCase;
import com.hhplus.task.domain.concert.models.Concert;
import com.hhplus.task.domain.concert.models.ConcertApplyHistory;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/concert")
@RequiredArgsConstructor
public class ConcertController {

    private GetConcertListUseCase getConcertListUseCase;
    private GetTurnNumberUseCase getTurnNumberUseCase;
    private ReserveConcertUseCase reserveConcertUseCase;
    private PayConcertUseCase payConcertUseCase;

    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 콘서트 리스트 가져오기
     * <hr/>
     *
     * 현재 있는 콘서트 목록을 볼 수 있다.
     *
     * @param isAll true:모든 콘서트 목록을 가져온다. false(기본값):현재 사용자의 토큰으로만 신청할 수 있는 콘서트만 가져온다.
     * @return
     */
    @GetMapping("/")
    @CheckToken
    public ResponseEntity<List<Concert>> getConcertList(
            @RequestParam(value = "false", required = false) boolean isAll){
        return new ResponseEntity<>(getConcertListUseCase.execute(isAll),HttpStatus.OK);
    }

    /**
     * <h1>대기열 순번 출력</h1>
     *
     * @return 대기열 순번
     */
    @GetMapping("/turn")
    @CheckToken
    public ResponseEntity<Long> getTurnNumber(@AccessTokenValue String token){
        return new ResponseEntity<>(getTurnNumberUseCase.execute(token), HttpStatus.OK);
    }

    /**
     * <h1>콘서트 예약</h1>
     *
     * @return
     */
    @PutMapping("")
    @CheckToken
    public ResponseEntity<ConcertApplyHistory> reserveConcert(@RequestBody ConcertRequestDto concertRequestDto){
        return new ResponseEntity<>(reserveConcertUseCase.execute(concertRequestDto), HttpStatus.OK);
    }

    /**
     * <h1>콘서트 결제</h1>
     *
     * @return
     */
    @PostMapping("")
    public ResponseEntity<ConcertApplyHistory> payConcert(@RequestBody ConcertRequestDto concertRequestDto){
        return new ResponseEntity<>(payConcertUseCase.execute(concertRequestDto), HttpStatus.OK);
    }
}
