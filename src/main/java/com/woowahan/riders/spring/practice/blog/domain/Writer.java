package com.woowahan.riders.spring.practice.blog.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leejaeil on 2016. 3. 14..
 */
@Entity
public class Writer {
    @Id
    @GeneratedValue
    private Long id;

    private String nickname;

    @OneToMany(mappedBy = "writer", orphanRemoval = true)
    private List<Site> siteList = new ArrayList<>();

    @OneToMany(mappedBy = "writer", orphanRemoval = true)
    private List<Post> postList = new ArrayList<>();

    void appendSite(Site site) {
        siteList.add(site);
    }

    void appendPost(Post post) {
        postList.add(post);
    }

    public Long getId() {
        return id;
    }

    public List<Site> getSiteList() {
        return siteList;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public String getNickname() {
        return nickname;
    }
}
