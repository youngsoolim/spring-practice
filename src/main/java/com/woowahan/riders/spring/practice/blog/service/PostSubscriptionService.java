package com.woowahan.riders.spring.practice.blog.service;

import com.woowahan.riders.spring.practice.blog.domain.Post;

import java.util.Optional;

/**
 * Created by leejaeil on 2016. 3. 15..
 */
public interface PostSubscriptionService {
    Optional<Post> readOne(Long postId);
}
