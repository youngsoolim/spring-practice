package com.woowahan.riders.spring.practice.blog.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by leejaeil on 2016. 3. 14..
 */
public class SiteTest {

    @Test
    public void testOf() throws Exception {
        // Given
        Writer writer = new Writer();
        // When
        Site site = Site.of(writer, "sonegy");
        // Then
        assertThat("compare endpoint", site.getEndpoint(), is("sonegy"));
        assertThat("compare writer", site.getWriter(), is(writer));
        assertThat("writer contain site", writer.getSiteList().get(0), is(site));
    }
}