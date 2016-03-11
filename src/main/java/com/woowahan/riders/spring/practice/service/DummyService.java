package com.woowahan.riders.spring.practice.service;

import com.woowahan.riders.spring.practice.helloworld.domain.HelloWorld;
import com.woowahan.riders.spring.practice.helloworld.domain.QHelloWorld;
import com.woowahan.riders.spring.practice.helloworld.repository.HelloWorldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by leejaeil on 2016. 3. 10..
 */
@Service
@Transactional
public class DummyService {

    @Autowired
    private HelloWorldRepository helloWorldRepository;

    public void writeDummy() {
        for (int i = 0; i < 10; i++) {
            helloWorldRepository.save(HelloWorld.createOf("text" + i, HelloWorld.WorldType.TYPE1));
        }
    }

    @Transactional(readOnly = true)
    public List<HelloWorld> readDummy() {
        return helloWorldRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Iterable<HelloWorld> readDummy2() {
        QHelloWorld helloWorld = QHelloWorld.helloWorld;
        return helloWorldRepository.findAll(helloWorld.id.eq(1l));
    }
}
