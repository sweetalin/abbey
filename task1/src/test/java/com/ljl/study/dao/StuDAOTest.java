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

import com.ljl.study.entity.Stu;

/** 
* @author alin 
* @version 2017年6月7日
* 类说明 
*/
public class StuDAOTest {
	public static SqlSessionFactory sqlSessionFactory = null;
	@Before
	public void setUp() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@After
	public void tearDown() throws Exception {
	}
	/**
	 * 根据id查询学员
	 * @throws Exception
	 */
	@Test
	public void testQueryById()  throws Exception{
		Stu stu = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {

			/* Un-recommended Method */
			
			/*
			 * stu = (Stu)session.selectOne(
			 * "com.nicchagil.mybatisonly.mapper.UserMapper.queryUser",username);
			 */

			/* Recommended Method */
			StuDAO stuDAO = session.getMapper(StuDAO.class);
			stu = stuDAO.queryById(1);

			System.out.println("id - " + stu.getId() + " , name - " + stu.getName());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	/**
	 * 查询所有学员信息
	 */
	@Test
	public void testQueryAll() {
		List<Stu> all = new ArrayList<Stu>();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			StuDAO stuDAO = session.getMapper(StuDAO.class);
			all = stuDAO.queryAll();
			for (int i = 0; i < all.size(); i++) {//遍历集合
			    System.out.println(all.get(i).toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	/**
	 * 最初用的方法，和前面的是不一样的，也不推荐
	 */
	@Ignore
	public void test() {
		//获取资源文件
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

			// 得到sessionFactory，使用类加载器获取xml文件
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
			// 打开session，创建能够执行配置文件中sql的：sqlSession
			SqlSession session = factory.openSession();
			// 查询一个对象，session.selectOne("注册过的命名空间sql映射 + servlet 的id，第几个");
			Stu stu= session.selectOne("com.ljl.study.entity.Stu.getStu", 1);
			System.out.println(stu);
			session.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
