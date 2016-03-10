package com.woowahan.riders.spring.practice.service;

import com.woowahan.riders.spring.practice.SpringPracticeApplication;
import com.woowahan.riders.spring.practice.helloworld.domain.HelloWorld;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by leejaeil on 2016. 3. 10..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {SpringPracticeApplication.class})
@WebAppConfiguration
@Transactional
public class DummyServiceTest {

    @Autowired
    private DummyService dummyService;

    @Test
    public void testReadDummy() throws Exception {
        // Given
        dummyService.writeDummy();
        // When
        List<HelloWorld> helloWorlds = dummyService.readDummy();
        int size = helloWorlds.size();
        // Then
        assertThat("HelloWorld 객체개 미리 만들어짐", size, is(10));
    }
}