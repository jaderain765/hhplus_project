package com.hhplus.task.api.point.controller;

import com.hhplus.task.api.point.dto.PointChangeDto;
import com.hhplus.task.api.point.usecase.ChangePointUseCase;
import com.hhplus.task.api.point.usecase.GetPointUseCase;
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

    private final GetPointUseCase getPointUseCase;
    private final ChangePointUseCase changePointUseCase;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/{userId}")
    public ResponseEntity<Long> getPoint(@PathVariable Long userId){
        return new ResponseEntity<>(getPointUseCase.execute(userId), HttpStatus.OK);
    }

    @PostMapping("/charge")
    public ResponseEntity<Long> chargePoint(@RequestBody PointChangeDto pointChangeDto){
        return new ResponseEntity<>(changePointUseCase.execute(pointChangeDto), HttpStatus.OK);
    }
}
