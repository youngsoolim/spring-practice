package com.woowahan.riders.spring.practice.blog.controller;

import com.woowahan.riders.spring.practice.SpringPracticeApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by leejaeil on 2016. 3. 16..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringPracticeApplication.class)
@WebAppConfiguration
@Transactional
public class BlogPostControllerTest {

    @Autowired
    WebApplicationContext wac;
//    @Autowired
//    MockServletContext servletContext;
//    @Autowired
//    MockHttpSession session;
//    @Autowired
//    MockHttpServletRequest request;
//    @Autowired
//    MockHttpServletResponse response;
//    @Autowired
//    ServletWebRequest webRequest;

    MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testGetPosts() throws Exception {
        mockMvc.perform(get("/blog/posts")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.posts[0].title").value("title 1"))
                .andExpect(jsonPath("$.posts[1].title").value("title 2"));
    }

    @Test
    public void testView() throws Exception {

    }

    @Test
    public void testWrite() throws Exception {

    }
}