package com.woowahan.riders.spring.practice.blog.service;

import com.woowahan.riders.spring.practice.blog.domain.Post;
import com.woowahan.riders.spring.practice.blog.domain.Site;
import com.woowahan.riders.spring.practice.blog.domain.Writer;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by leejaeil on 2016. 3. 15..
 */
public class PostPublishServiceTest {
    PostPublishService postPublishService;

    @Before
    public void setUp() throws Exception {
        postPublishService = new PostPublishService() {
            @Override
            public Optional<Post> writePost(Writer writer, Site site, String title, String content) {
                return Optional.of(Post.of(writer, site, title, content));
            }
        };
    }

    @Test
    public void testWritePost() throws Exception {
        // Given
        Writer writer = new Writer();
        Site site = Site.of(writer, "sonegy");
        // When
        Optional<Post> newPost = postPublishService.writePost(writer, site, "title", "content");
        // Then
        assertTrue(newPost.isPresent());
        newPost.ifPresent(post -> {
            assertThat(post.getTitle(), is("title"));
            assertThat(post.getContent(), is("content"));
            assertThat(post.getSite(), is(site));
            assertThat(post.getWriter(), is(writer));
        });
    }
}