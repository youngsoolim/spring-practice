package com.woowahan.riders.spring.practice.helloworld.repository;

import com.woowahan.riders.spring.practice.helloworld.domain.HelloWorld;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by leejaeil on 2016. 3. 10..
 */
public interface HelloWorldRepository extends JpaRepository<HelloWorld, Long>, QueryDslPredicateExecutor {
}
