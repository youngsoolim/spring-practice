package com.woowahan.riders.spring.practice.blog.controller.dto;

/**
 * Created by leejaeil on 2016. 3. 16..
 */
public class PostRequest {
    private Long id;
    private String title;
    private String content;

    public static PostRequest empty() {
        return new PostRequest();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PostRequest{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
