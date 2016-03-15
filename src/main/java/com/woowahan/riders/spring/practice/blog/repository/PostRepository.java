package com.woowahan.riders.spring.practice.blog.repository;

import com.woowahan.riders.spring.practice.blog.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by leejaeil on 2016. 3. 14..
 */
public interface PostRepository extends JpaRepository<Post, Long>, QueryDslPredicateExecutor<Post> {
}
