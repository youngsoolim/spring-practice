package com.woowahan.riders.spring.practice.blog.controller.dto;

import java.util.List;

/**
 * Created by yslim on 3/22/16.
 */
public class CommentsResponse {
    private List<CommentResponse> comments;

    public static CommentsResponse of(List<CommentResponse> commentsResponse) {
        CommentsResponse response = new CommentsResponse();
        response.setComments(commentsResponse);
        return response;
    }

    public List<CommentResponse> getComments() {
        return comments;
    }

    public void setComments(List<CommentResponse> comments) {
        this.comments = comments;
    }
}
