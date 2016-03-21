package com.woowahan.riders.spring.practice.blog.service;

import com.woowahan.riders.spring.practice.blog.domain.Comment;
import com.woowahan.riders.spring.practice.blog.domain.Post;
import com.woowahan.riders.spring.practice.blog.domain.Site;

import java.util.List;
import java.util.Optional;

/**
 * Created by leejaeil on 2016. 3. 15..
 */
public interface PostSubscriptionService {

    Optional<Post> readOne(Long postId);

    List<Post> readAll(String endpoint);

}
