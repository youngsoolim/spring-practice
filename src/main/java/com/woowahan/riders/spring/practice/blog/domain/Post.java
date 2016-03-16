package com.woowahan.riders.spring.practice.blog.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by leejaeil on 2016. 3. 14..
 */
@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    private Writer writer;

    @ManyToOne
    private Site site;

    @OneToMany(mappedBy = "post", orphanRemoval = true)
    private List<Comment> commentList = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;

    public static Post of(Writer writer, Site site, String title, String content) {
        Post post = new Post();
        post.title = title;
        post.content = content;
        post.writer = writer;
        post.site = site;
        post.createdDateTime = new Date();

        // 한번의 Transaction 혹은 Session 안에서 mappedBy로 묶은 역방향은 데이터가 양방향 싱크가 되지 않음으로 수동으로 처리해준다.
        // 하지만 이것은 대부분 TestCase 에서 통과를 위한 코드일분 실제 환경상에서는 서로 다른 Transaction, Session 으로 처리됨으로
        // 문제가 되지 않는다.
        writer.appendPost(post);
        site.appendPost(post);
        return post;
    }

    void appendComment(Comment comment) {
        commentList.add(comment);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Writer getWriter() {
        return writer;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public Site getSite() {
        return site;
    }
}
