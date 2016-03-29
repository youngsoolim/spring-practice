package com.woowahan.riders.spring.practice.blog.controller.dto;

/**
 * Created by yslim on 3/24/16.
 */
public class CommentRequest {

    private String content;

    public static CommentRequest empty() {
        return new CommentRequest();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
