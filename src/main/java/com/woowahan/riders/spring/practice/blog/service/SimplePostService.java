package com.woowahan.riders.spring.practice.blog.service;

import com.woowahan.riders.spring.practice.blog.domain.Post;
import com.woowahan.riders.spring.practice.blog.domain.QPost;
import com.woowahan.riders.spring.practice.blog.domain.Site;
import com.woowahan.riders.spring.practice.blog.domain.Writer;
import com.woowahan.riders.spring.practice.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by leejaeil on 2016. 3. 15..
 */
@Service
@Transactional
public class SimplePostService implements PostPublishService, PostSubscriptionService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public Optional<Post> writePost(Writer writer, Site site, String title, String content) {
        return Optional.of(postRepository.save(Post.of(writer, site, title, content)));
    }

    @Override
    public Optional<Post> readOne(Long id) {
        QPost post = QPost.post;
        return Optional.of(postRepository.findOne(post.id.eq(id)));
    }
}
