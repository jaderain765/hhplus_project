package com.hhplus.task.annotation;

import com.hhplus.task.domain.token.component.TokenModifier;
import com.hhplus.task.domain.token.component.TokenReader;
import com.hhplus.task.exception.CustomRuntimeException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
@RequiredArgsConstructor
public class CheckTokenAspect {

    private final TokenReader tokenReader;
    private final TokenModifier tokenModifier;

    @Before("@annotation(com.hhplus.task.annotation.CheckToken)")
    public void checkToken(JoinPoint joinPoint){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("token");

        if(!tokenReader.isUseable(token)){
            tokenModifier.discardToken(token);
            throw new CustomRuntimeException("만료된 토큰입니다.");
        }

        for(Object arg : joinPoint.getArgs()){
            if(arg.getClass().isAnnotationPresent(AccessTokenValue.class)){
                arg = token;
                break;
            }
        }
    }
}
