package com.woowahan.riders.spring.practice.blog.controller.dto;

import com.woowahan.riders.spring.practice.blog.domain.Comment;

import java.util.Date;

/**
 * Created by yslim on 3/22/16.
 */
public class CommentResponse {
    private Long id;
    private String content;
    private Date createdDateTime;

    public static CommentResponse of(Long id, String content, Date createdDateTime) {
        CommentResponse commentResponse = new CommentResponse();
        commentResponse.setId(id);
        commentResponse.setContent(content);
        commentResponse.setCreatedDateTime(createdDateTime);
        return commentResponse;
    }

    public static CommentResponse of(Comment comment) {
        CommentResponse commentResponse = new CommentResponse();
        commentResponse.setId(comment.getId());
        commentResponse.setContent(comment.getContent());
        commentResponse.setCreatedDateTime(comment.getCreatedDateTime());
        return commentResponse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

}
