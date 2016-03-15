package com.woowahan.riders;

import com.woowahan.riders.spring.practice.SpringPracticeApplication;
import com.woowahan.riders.spring.practice.blog.service.PostPublishService;
import com.woowahan.riders.spring.practice.blog.service.PostSubscriptionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringPracticeApplication.class)
@WebAppConfiguration
public class SpringPracticeApplicationTests {

	@Autowired
	ApplicationContext applicationContext;

	@Test
	public void contextLoads() {
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}

		PostPublishService postPublishService =
				applicationContext.getBean("simplePostService", PostPublishService.class);
		PostSubscriptionService postSubscriptionService =
				applicationContext.getBean("simplePostService", PostSubscriptionService.class);
		assertNotNull(postPublishService);
		assertNotNull(postSubscriptionService);
	}

}
