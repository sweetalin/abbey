package com.oeasy.baseTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @author alin
 *
 * 2017年6月13日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/spring.xml"})
public class TestCase {
    protected org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    public void testContext(){
    	logger.info("spring 和 memcache 环境 测试完毕");
    }
}