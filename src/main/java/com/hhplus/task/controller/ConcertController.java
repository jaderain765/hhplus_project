package com.hhplus.task.controller;

import com.hhplus.task.dto.ConcertRequestDto;
import com.hhplus.task.entity.ConcertEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
     * @param isALl true:모든 콘서트 목록을 가져온다. false(기본값):현재 사용자의 토큰으로만 신청할 수 있는 콘서트만 가져온다.
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<List<ConcertEntity>> getConcertList(@RequestParam(value = "false", required = false) boolean isALl){


        List<ConcertEntity> result = new ArrayList<>();

        result.add(new ConcertEntity(1L, "콘서트1", 20000, 50, LocalDateTime.now(), LocalDateTime.now()));
        result.add(new ConcertEntity(2L, "콘서트2", 10000, 50, LocalDateTime.now(), LocalDateTime.now()));
        result.add(new ConcertEntity(3L, "콘서트3", 50000, 50, LocalDateTime.now(), LocalDateTime.now()));
        result.add(new ConcertEntity(4L, "콘서트4", 90000, 50, LocalDateTime.now(), LocalDateTime.now()));
        result.add(new ConcertEntity(5L, "콘서트5", 10000, 50, LocalDateTime.now(), LocalDateTime.now()));

        // 해당 콘서트는 이미 만원인 데이터다.
        if(isALl){
            result.add(new ConcertEntity(6L, "콘서트6", 120000, 50, LocalDateTime.now(), LocalDateTime.now()));
            result.add(new ConcertEntity(7L, "콘서트7", 100000, 50, LocalDateTime.now(), LocalDateTime.now()));
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * <h1>대기열 순번 출력</h1>
     *
     * @return 대기열 순번
     */
    @GetMapping("/turn")
    public ResponseEntity<Long> getTurnNumber(){
        return new ResponseEntity<>(1L, HttpStatus.OK);
    }

    /**
     * <h1>콘서트 예약</h1>
     *
     * @return
     */
    @PutMapping("")
    public ResponseEntity<Object> reserveConcert(@RequestBody ConcertRequestDto concertRequestDto){
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
