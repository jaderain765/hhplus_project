package com.hhplus.task.controller;

import com.hhplus.task.dto.ConcertRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/concert")
public class ConcertController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 콘서트 리스트 가져오기
     * <hr/>
     *
     * 현재 있는 콘서트 목록을 볼 수 있다.
     *
     * @param token 사용자 대기열 토큰
     * @param isALl true:모든 콘서트 목록을 가져온다. false(기본값):현재 사용자의 토큰으로만 신청할 수 있는 콘서트만 가져온다.
     * @return
     */
    @GetMapping("/{token}")
    public ResponseEntity<List<Object>> getConcertList(@PathVariable String token, @RequestParam(value = "false", required = false) boolean isALl){
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
    }

    /**
     * <h1>대기열 순번 출력</h1>
     *
     * @param token 사용자 토큰
     * @return 대기열 순번
     */
    @GetMapping("/turn/{token}")
    public ResponseEntity<Long> getTurnNumber(@PathVariable String token){
        return new ResponseEntity<>(1L, HttpStatus.OK);
    }

    /**
     * <h1>콘서트 예약</h1>
     *
     * @return
     */
    @PutMapping("/{token}")
    public ResponseEntity<Object> reserveConcert(
            @PathVariable String token,
            @RequestBody ConcertRequestDto concertRequestDto
    ){
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    /**
     * <h1>콘서트 결재</h1>
     *
     * @return
     */
    @PostMapping("")
    public ResponseEntity<Object> payConcert(@RequestBody ConcertRequestDto concertRequestDto){
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}
