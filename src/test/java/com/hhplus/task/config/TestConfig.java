package com.hhplus.task.config;

import com.hhplus.task.domain.concert.component.ConcertReader;
import com.hhplus.task.domain.concert.repositories.ConcertReaderRepository;
import com.hhplus.task.domain.token.component.TokenReader;
import com.hhplus.task.domain.token.repositories.TokenReaderRepository;
import com.hhplus.task.stub.ConcertReaderRepositoryStub;
import com.hhplus.task.stub.TokenReaderRepositoryStub;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;


@TestConfiguration
public class TestConfig {

    @Bean
    public TokenReader tokenReader(){
        return new TokenReader();
    }

    @Bean
    public ConcertReader concertReader(){
        return new ConcertReader();
    }

    @Bean
    public TokenReaderRepository tokenReaderRepository(){
        return new TokenReaderRepositoryStub();
    }

    @Bean
    public ConcertReaderRepository concertReaderRepository(){
        return new ConcertReaderRepositoryStub();
    }





}