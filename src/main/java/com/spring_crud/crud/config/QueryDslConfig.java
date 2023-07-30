package com.spring_crud.crud.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class QueryDslConfig {
    // 호돌버젼
    @PersistenceContext
    public EntityManager em;
    @Bean
    public JPAQueryFactory query(){
        return new JPAQueryFactory(em);
    }
    //TODO: kim version으로 구현하기
}
