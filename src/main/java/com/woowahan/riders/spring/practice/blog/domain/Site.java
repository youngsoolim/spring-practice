package com.woowahan.riders.spring.practice.blog.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leejaeil on 2016. 3. 14..
 */
@Entity
public class Site {

    @Id
    @GeneratedValue
    private Long id;

    private String endpoint;

    @ManyToOne
    private Writer writer;

    @OneToMany(mappedBy = "site", orphanRemoval = true)
    private List<Post> postList = new ArrayList<Post>();

    public static Site of(Writer writer, String endpoint) {
        Site site = new Site();
        site.endpoint = endpoint;
        site.writer = writer;
        writer.appendSite(site);
        return site;
    }

    void appendPost(Post post) {
        postList.add(post);
    }

    public Long getId() {
        return id;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public Writer getWriter() {
        return writer;
    }
}
