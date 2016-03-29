package com.woowahan.riders.spring.practice.blog.service;

import com.woowahan.riders.spring.practice.blog.domain.Comment;
import com.woowahan.riders.spring.practice.blog.domain.Post;
import com.woowahan.riders.spring.practice.blog.domain.Site;
import com.woowahan.riders.spring.practice.blog.domain.Writer;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by yslim on 3/21/16.
 */
public class CommentOfPostServiceTest {

    private CommentOfPostService commentOfPostService;
    static final Writer writer = new Writer();
    static final Site site1 = Site.of(writer, "sonegy");
    static final Post post1 = Post.of(writer, site1, "title1", "content1");
    private List<Comment> comments = Arrays.asList(
            Comment.of(post1, "comment1")
    );

    @Before
    public void setUp() throws Exception {
        commentOfPostService = new CommentOfPostService() {
            @Override
            public List<Comment> readComments(Post post) {
                return comments;
            }

            @Override
            public Optional<Comment> writeComment(Post post, String content) {
                return null;
            }

            @Override
            public void deleteComment(Long postId, Long commentId) { }
        };
    }

    @Test
    public void 해당_글의_댓글을_볼_수_있다() {
        List<Comment> comments = commentOfPostService.readComments(post1);
        assertThat(comments.size(), is(1));
    }
}
