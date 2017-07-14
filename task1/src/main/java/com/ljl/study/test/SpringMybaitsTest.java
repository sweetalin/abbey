package com.ljl.study.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ljl.study.dao.StuDAO;
import com.ljl.study.entity.Stu;

/** 
* @author alin 
* @version 2017年6月8日
* 类说明 
*/
public class SpringMybaitsTest {
	public static void main(String[] args) {
		
		 AbstractApplicationContext ctx=null;
		 ctx=new ClassPathXmlApplicationContext("classpath:applicationContext-mybatis.xml");
		 StuDAO stuDAO=(StuDAO) ctx.getBean("stuDAO");
		 /*List<Stu> all = new ArrayList<Stu>();
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
		}*/
		 Stu stu = new Stu();
		 try {
			stu=stuDAO.queryById(1);
			    System.out.println(stu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ctx.close();
		} 
		 
	}
}
