package com.woowahan.riders.spring.practice.blog.service;

import com.woowahan.riders.spring.practice.blog.domain.QSite;
import com.woowahan.riders.spring.practice.blog.domain.Site;
import com.woowahan.riders.spring.practice.blog.domain.Writer;
import com.woowahan.riders.spring.practice.blog.repository.SiteRepository;
import com.woowahan.riders.spring.practice.blog.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by leejaeil on 2016. 3. 18..
 */
@Service
@Transactional
public class DummyAuthenticatedService {

    @Autowired
    private WriterRepository writerRepository;
    @Autowired
    private SiteRepository siteRepository;

    /**
     * 현재 인증 처리가 되지 않음으로 임시적으로 Site와 계정을 생성한다.
     *
     * @param endpoint
     * @return
     */
    public Writer getWriterBy(String endpoint) {
        Writer writer = writerRepository.findAll(new PageRequest(0, 1))
                .getContent()
                .stream()
                .findFirst()
                .orElseGet(() -> writerRepository.save(new Writer()));
        QSite site = QSite.site;
        Optional.ofNullable(siteRepository.findOne(site.endpoint.eq(endpoint)))
                .orElseGet(() -> siteRepository.save(Site.of(writer, endpoint)));
        return writer;
    }
}