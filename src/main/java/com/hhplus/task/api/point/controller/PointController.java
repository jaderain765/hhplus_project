package com.hhplus.task.api.point.controller;

import com.hhplus.task.api.point.dto.PointChangeDto;
import com.hhplus.task.exception.CustomRuntimeException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/point")
public class PointController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/{userId}")
    public ResponseEntity<Long> getPoint(@PathVariable Long userId){

        if(userId == null || userId < 0L) throw new CustomRuntimeException("사용자 정보를 찾을 수 없습니다.");

        return new ResponseEntity<>(1000L, HttpStatus.OK);
    }

    @GetMapping("/charge")
    public ResponseEntity<Long> chargePoint(@RequestBody PointChangeDto pointChangeDto){

        if(pointChangeDto.getUserId() == null || pointChangeDto.getUserId() < 0L)
            throw new CustomRuntimeException("사용자 정보를 찾을 수 없습니다.");

        if(pointChangeDto.getAmount() == null || pointChangeDto.getAmount() < 0L)
            throw new CustomRuntimeException("사용/충전에 실패하였습니다.");

        if(pointChangeDto.getPointStatus() == null)
            throw new CustomRuntimeException("사용/충전에 실패하였습니다.");

        return new ResponseEntity<>(15000L, HttpStatus.OK);
    }
}
