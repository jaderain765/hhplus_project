package com.hhplus.task.domain.token.infrastructure;

import com.hhplus.task.domain.token.models.QTokenEntity;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class TokenQuerydslRepository {



    private final JPAQueryFactory jpaQueryFactory;

    QTokenEntity token = QTokenEntity.tokenEntity;

    public Long getTurnNumber(String tokenUUID){
        return 1L + jpaQueryFactory.select(token.tokenUUID.indexOf(tokenUUID))
                .from(token)
                .where(token.validTime.isNull())
                .orderBy(token.createTime.asc())
                .fetchOne();
    }

    /**
     * 만료된 토큰을 삭제하고, 삭제한 개수를 반환한다.
     *
     * @return
     */
    public Long expiredTokenDelete(){
        return jpaQueryFactory.delete(token)
                .where(token.validTime.after(LocalDateTime.now()))
                .execute();
    }

    /**
     * 권한이 있는 token 수
     */
    public Long authorityTokenCount(){
        return jpaQueryFactory
                .select(token.count())
                .from(token)
                .where(token.validTime.isNotNull())
                .fetchOne();
    }

    /**
     *
     *
     * @param limit
     * @return
     */
    public List<String> findGiveAuthorityList(long limit){
        return jpaQueryFactory
                .select(token.tokenUUID)
                .from(token)
                .where(token.validTime.isNull())
                .orderBy(token.createTime.asc())
                .limit(limit)
                .fetch();
    }

    public Long tokenGiveAuthority(List<String> tokenList){
        // 권한을 부여할 토큰 조건 생성
        BooleanBuilder builder = new BooleanBuilder();

        tokenList.forEach(t -> builder.or(token.tokenUUID.eq(t)));

        // 권한 부여 및 개수 반환
        return jpaQueryFactory
                .update(token)
                .set(token.validTime, LocalDateTime.now().plusSeconds(5L * 60)) // 5분간 접속권한을 준다.
                .where(builder)
                .execute();
    }

}
