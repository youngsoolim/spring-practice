package com.woowahan.riders.spring.practice.blog.service;

import com.woowahan.riders.spring.practice.blog.domain.Post;
import com.woowahan.riders.spring.practice.blog.domain.Site;
import com.woowahan.riders.spring.practice.blog.domain.Writer;

import java.util.Optional;

/**
 * Created by leejaeil on 2016. 3. 15..
 */
public interface PostPublishService {
    Optional<Post> writePost(Writer writer, Site site, String title, String content);
}
