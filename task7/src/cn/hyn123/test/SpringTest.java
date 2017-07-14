package cn.hyn123.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.hyn123.dao.UserDao;
import cn.hyn123.entities.User;

/** 
* @author alin 
* @version 2017年6月14日
* 类说明 
*/
public class SpringTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ctx = null;
		ctx = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
		UserDao userDao = (UserDao) ctx.getBean("userDao");
		User user = new User();
		
		// 添加一条数据
		user.setUserName("Jessica");
		user.setPassWord("123");
		try {
			userDao.insertUser(user);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		System.out.println("添加成功");
		
		// 查询数据
		try {
			System.out.println(userDao.findUserById(2).toString());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		System.out.println("查询成功");
		
		// 修改数据
		try {
			userDao.midifyPassWord("Jessica", "321");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("修改成功");
		
		// 删除数据
		try {
			userDao.deleteUser(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("删除成功");

	}
}
