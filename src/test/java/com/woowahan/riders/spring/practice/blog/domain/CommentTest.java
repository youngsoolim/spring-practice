package com.woowahan.riders.spring.practice.blog.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

/**
 * Created by leejaeil on 2016. 3. 14..
 */
public class CommentTest {

    @Test
    public void testOf() throws Exception {
        // Given
        Post post = new Post();
        // When
        Comment comment = Comment.of(post, "content");
        // Then
        assertThat("compare content", comment.getContent(), is("content"));
        assertThat("compare content", comment.getPost(),is(post));
        assertThat("not null createdDateTime", comment.getCreatedDateTime(), is(notNullValue()));
        assertThat("contain comment", comment.getPost().getCommentList().get(0), is(comment));
    }
}