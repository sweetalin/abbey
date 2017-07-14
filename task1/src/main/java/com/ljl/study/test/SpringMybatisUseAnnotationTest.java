package com.ljl.study.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ljl.study.dao.StuDAO;
import com.ljl.study.entity.Stu;

/** 
* @author alin 
* @version 2017年6月8日
* 类说明 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringMybatisUseAnnotationTest {
	@Autowired
    private StuDAO stuDAO;
 
    @Test
    public void testQueryById() {
    	Stu stu = new Stu();
    	try {
			stu = stuDAO.queryById(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	System.out.println(stu);
    }
 
    @Test
    public void testQueryAll() {
        List<Stu> all;
		try {
			all = stuDAO.queryAll();
			for (Stu s : all) {
		            System.out.println(s);
		        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
    }
}
