package com.woowahan.riders;

import com.woowahan.riders.spring.practice.SpringPracticeApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringPracticeApplication.class)
@WebAppConfiguration
public class SpringPracticeApplicationTests {

	@Test
	public void contextLoads() {
	}

}
