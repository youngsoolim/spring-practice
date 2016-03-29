package com.woowahan.riders.spring.practice.blog.service;

import com.woowahan.riders.spring.practice.blog.domain.Comment;
import com.woowahan.riders.spring.practice.blog.domain.Post;

import java.util.List;
import java.util.Optional;

/**
 * Created by yslim on 3/21/16.
 */
public interface CommentOfPostService {
    List<Comment> readComments(Post post);

    Optional<Comment> writeComment(Post post, String content);

    void deleteComment(Long postId, Long commentId);
}
