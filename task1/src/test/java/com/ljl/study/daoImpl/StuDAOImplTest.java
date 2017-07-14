package com.ljl.study.daoImpl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ljl.study.entity.Stu;

/** 
* @author alin 
* @version 2017年6月7日
* 类说明 
*/
public class StuDAOImplTest {
	Stu stu =null;
	List<Stu> all = new ArrayList<Stu>();
	StuDAOImpl stuDAOImpl =null;
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testQueryById() {
		stu  = new Stu();
		stuDAOImpl = new StuDAOImpl();
		try {
			stu = stuDAOImpl.queryById(1);
			System.out.println(stu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//fail("Not yet implemented");
	}

	@Test
	public void testQueryAll() {
		stuDAOImpl = new StuDAOImpl();
		try {
			all = stuDAOImpl.queryAll();
//			System.out.println(all);
			for (int i = 0; i < all.size(); i++) {//遍历集合
			    System.out.println(all.get(i).toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//fail("Not yet implemented");
	}

}
