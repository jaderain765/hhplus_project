package com.hhplus.task.controller;

import com.hhplus.task.dto.PointChangeDto;
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
        return new ResponseEntity<>(0L, HttpStatus.OK);
    }

    @GetMapping("/charge")
    public ResponseEntity<Long> chargePoint(@RequestBody PointChangeDto pointChangeDto){
        return new ResponseEntity<>(0L, HttpStatus.OK);
    }

    @GetMapping("/use")
    public ResponseEntity<Long> usePoint(@RequestBody PointChangeDto pointChangeDto){
        return new ResponseEntity<>(0L, HttpStatus.OK);
    }
}
