package com.woowahan.riders.spring.practice.helloworld.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by leejaeil on 2016. 3. 10..
 */
@Entity
@Table(name = "hello_world", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class HelloWorld {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 100)
    private String text;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Enumerated(EnumType.STRING)
    private WorldType worldType;

    public static HelloWorld createOf(String text, WorldType worldType) {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.text = text;
        helloWorld.worldType = worldType;
        helloWorld.createDate = new Date();
        return helloWorld;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public WorldType getWorldType() {
        return worldType;
    }

    public enum WorldType {
        TYPE1, TYPE2
    }
}
