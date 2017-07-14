package com.oeasy.service;

import com.danga.MemCached.MemCachedClient;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author alin
 *
 * 2017年6月13日
 */
public class TestMemcache {
    private MemCachedClient memCachedClient;
    @Before
    public void beforeTest() {
        ApplicationContext atx = new ClassPathXmlApplicationContext("classpath:conf/spring-memcached.xml");
        memCachedClient = (MemCachedClient) atx.getBean("memCachedClient");
    }
    @Test
    public void TestMem() {
    	/*replace 方法用于替换一个指定 key 的缓存内容，如果 key 不存在则返回 false*/
//        memCachedClient.replace("age1", "ming");
//        System.out.println(memCachedClient.get("age1"));
    	
       /* add 方法用于向 memcache 服务器添加一个要缓存的数据*/
        memCachedClient.add("age2", "xin");
        System.out.println(memCachedClient.get("age2"));
    }
}