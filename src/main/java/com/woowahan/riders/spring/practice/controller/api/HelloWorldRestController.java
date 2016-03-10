package com.woowahan.riders.spring.practice.controller.api;

import com.woowahan.riders.spring.practice.service.DummyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by leejaeil on 2016. 3. 10..
 */
@RestController
@RequestMapping("/hello-world")
public class HelloWorldRestController {
    static final Logger logger = LoggerFactory.getLogger(HelloWorldRestController.class);

    @Autowired
    private DummyService dummyService;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String root() {
        dummyService.writeDummy();
        dummyService.readDummy();
        return "hello world main";
    }
}
