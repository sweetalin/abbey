package com.ljl.study.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ljl.study.daoImpl.StuDAOImpl;
import com.ljl.study.entity.Stu;

/** 
* @author alin 
* @version 2017年6月7日
* 类说明 
*/
public class StuDAOTest2 {
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	/**
	 * 根据id查询学员
	 * @throws Exception
	 */
	@Ignore
	public void testQueryById()  throws Exception{

	}
	/**
	 * 查询所有学员信息
	 */
	@Test
	public void testQueryAll() {
		 AbstractApplicationContext ctx=null;
		 ctx=new ClassPathXmlApplicationContext("classpath:applicationContext-mybatis.xml");
		 StuDAO stuDAO=(StuDAO) ctx.getBean("stuDAO");
		 
		 List<Stu> all = new ArrayList<Stu>();
		 try {
			System.out.println(stuDAO);
			all=stuDAO.queryAll();
			for (int i = 0; i < all.size(); i++) {//遍历集合
			    System.out.println(all.get(i).toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ctx.close();
		}
		 
	}

}
