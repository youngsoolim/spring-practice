package com.woowahan.riders.spring.practice.blog.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by leejaeil on 2016. 3. 16..
 */
public class StandaloneBlogPostControllerTest {
    MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(new BlogPostController()).build();
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
        mockMvc.perform(get("/blog/posts/{id}", 1l)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.post.title").value("title 1"));
    }

    @Test
    public void testWrite() throws Exception {
        mockMvc.perform(post("/blog/posts")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"title\": \"title\",\n" +
                        "  \"content\": \"content\"\n" +
                        "}"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }
}