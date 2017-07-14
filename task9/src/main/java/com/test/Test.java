package com.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.dao.StudentDAO;
import com.test.entity.Student;
import com.test.service.IStudentService;
import com.test.serviceImpl.StudentServiceImpl;

/** 
* @author alin 
* @version 2017年6月18日
* 类说明 
*/
public class Test {
    private static StudentDAO studentDAO;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    	try {
            ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
            studentDAO =(StudentDAO)act.getBean("studentDAO");
		} catch (Exception e) {
			e.printStackTrace();
		}

    }
    
    @org.junit.Test
    public void test(){
    	
    	 List<Student> ls = new ArrayList<>();
    	 ls=studentDAO.findAll(Date.class);
    	 System.out.println(ls);
    }
}
