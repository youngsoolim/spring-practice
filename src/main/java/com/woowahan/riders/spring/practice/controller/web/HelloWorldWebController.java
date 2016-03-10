package com.woowahan.riders.spring.practice.controller.web;

import com.woowahan.riders.spring.practice.helloworld.domain.HelloWorld;
import com.woowahan.riders.spring.practice.service.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by leejaeil on 2016. 3. 10..
 */
@Controller
@RequestMapping("/web/hello-world")
public class HelloWorldWebController {
    @Autowired
    private DummyService dummyService;

    @RequestMapping(value = {"view"}, method = RequestMethod.GET)
    public void view(Model model) {
        dummyService.writeDummy();
        List<HelloWorld> helloWorlds = dummyService.readDummy();
        model.addAttribute("name", "name1");
        model.addAttribute("helloWorlds", helloWorlds);
    }

    @RequestMapping(value = {"view2"}, method = RequestMethod.GET)
    public String view2(Model model) {
        model.addAttribute("name", "name2");
        return "web/hello-world/view";
    }
}
