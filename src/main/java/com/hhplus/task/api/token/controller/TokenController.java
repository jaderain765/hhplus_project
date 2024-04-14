package com.hhplus.task.api.token.controller;

import com.hhplus.task.api.token.usecase.GetTokenUseCase;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>Token 컨트롤러</h1>
 * <hr/>
 *
 * 해당 토큰을 기준으로 Concert의 대기열 로직을 실행한다.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/token")
public class TokenController {

    private GetTokenUseCase getTokenUseCase;

    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 토큰 받아오기
     *
     * @param userId - 사용자 아이디
     * @return - 대기열 토큰 반환
     */
    @GetMapping("/{userId}")
    public ResponseEntity<String> getToken(@PathVariable Long userId){
        return new ResponseEntity<>(getTokenUseCase.execute(userId), HttpStatus.OK);
    }
}
