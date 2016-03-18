package com.woowahan.riders.spring.practice.blog.service;

import com.woowahan.riders.spring.practice.SpringPracticeApplication;
import com.woowahan.riders.spring.practice.blog.domain.Writer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by leejaeil on 2016. 3. 18..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {SpringPracticeApplication.class})
@WebAppConfiguration
@Transactional
public class DummyAuthenticatedServiceTest {

    @Autowired
    private DummyAuthenticatedService dummyAuthenticatedService;

    @Test
    public void testGetWriterBy() throws Exception {
        // Given
        String endpoint = "sonegy";
        // When
        Writer writerBy = dummyAuthenticatedService.getWriterBy(endpoint);
        // Then
        assertThat(writerBy, is(notNullValue()));
        assertThat(writerBy.getSiteList().stream().findFirst().map(i -> i.getEndpoint()).get(), is(endpoint));
    }
}