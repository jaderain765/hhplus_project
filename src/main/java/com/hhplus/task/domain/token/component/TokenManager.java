package com.hhplus.task.domain.token.component;

import com.hhplus.task.domain.token.repositories.TokenReaderRepository;
import com.hhplus.task.domain.token.repositories.TokenStoreRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Component
public class TokenManager {

    private final Logger log = LoggerFactory.getLogger(getClass());

    // 대기열 크기
    private final long WAIT_LIST_SIZE = 50L;

    private TokenReaderRepository tokenReaderRepository;

    private TokenStoreRepository tokenStoreRepository;

    /**
     * 대기열 상황에 맞게 유효시간을 부여한다.
     */
    @Transactional
    public Long tokenRepair(){
        tokenStoreRepository.expiredTokenDelete();
        // 권한이 있는 token 수
        Long authorityCount = tokenReaderRepository.authorityTokenCount();

        // 접근권한을 줄 유저수
        long limit = (authorityCount == null)?
                WAIT_LIST_SIZE :
                WAIT_LIST_SIZE - authorityCount;

        // 접근권한을 줄 유저 목록
        List<String> giveTokenList = tokenReaderRepository.findGiveAuthorityList(limit);

        return tokenStoreRepository.tokenGiveAuthority(giveTokenList);
    }
}
