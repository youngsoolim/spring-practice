package com.woowahan.riders.spring.practice.blog.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by leejaeil on 2016. 3. 14..
 */
public class PostTest {

    @Test
    public void testOf() throws Exception {
        // Given
        Writer writer = new Writer();
        Site site = Site.of(writer, "sonegy");
        // When
        Post post = Post.of(writer, site, "title", "content");
        // Then
        assertThat("compare title", post.getTitle(), is("title"));
        assertThat("compare content", post.getContent(), is("content"));
        assertThat("compare writer", post.getWriter(), is(writer));
    }

}