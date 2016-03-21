package com.woowahan.riders.spring.practice.blog.service;

import com.woowahan.riders.spring.practice.blog.domain.Comment;
import com.woowahan.riders.spring.practice.blog.domain.Post;
import com.woowahan.riders.spring.practice.blog.domain.Site;
import com.woowahan.riders.spring.practice.blog.domain.Writer;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by leejaeil on 2016. 3. 15..
 */
public class PostSubscriptionServiceTest {
    PostSubscriptionService postSubscriptionService;

    static final Writer writer = new Writer();
    static final Site site1 = Site.of(writer, "sonegy");
    static final Post post1 = Post.of(writer, site1, "title1", "content1");

    @Before
    public void setUp() throws Exception {
        postSubscriptionService = new PostSubscriptionService() {
            @Override
            public Optional<Post> readOne(Long id) {
                if (id == 1l) {
                    return Optional.of(post1);
                }
                return Optional.empty();
            }

            @Override
            public List<Post> readAll(String endpoint) {
                return null;
            }

            @Override
            public List<Comment> getCommentsOfPost(Post post) {
                return null;
            }

        };
    }

    @Test
    public void testFindOne() throws Exception {
        // Given
        Long postId = 1l;
        // When
        Optional<Post> postOptional = postSubscriptionService.readOne(postId);
        // Then
        assertTrue(postOptional.isPresent());
        postOptional.ifPresent(post -> {
            assertThat(post.getTitle(), is("title1"));
            assertThat(post.getContent(), is("content1"));
        });
    }
}