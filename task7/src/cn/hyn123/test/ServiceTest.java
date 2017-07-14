package cn.hyn123.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.hyn123.dao.EmailCaptchaDao;
import cn.hyn123.dao.UserDao;
import cn.hyn123.entities.EmailCaptcha;
import cn.hyn123.entities.User;
import cn.hyn123.service.EmailCaptchaService;

/** 
* @author alin 
* @version 2017年6月14日
* 类说明 
*/
public class ServiceTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ctx = null;
		ctx = new ClassPathXmlApplicationContext( (new String[]{"spring/spring-dao.xml","spring/spring-service.xml"}) );
		
		//测试给邮箱发送验证码
		try {
			EmailCaptchaService emailCaptchaService = (EmailCaptchaService) ctx.getBean("emailCaptchaService");
			UserDao userDao = (UserDao) ctx.getBean("userDao");
			String user = userDao.findUserByEmail("liujilin2017@qq.com").getUserName();
			emailCaptchaService.sendEmail(user, "123");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//测试邮箱验证码数据插入
		/*EmailCaptchaDao emailCaptchaDao = (EmailCaptchaDao) ctx.getBean("EmailCaptchaDao");
		EmailCaptcha emailCaptchar = new EmailCaptcha();
		
		emailCaptchar.setCaptcha("abc");
		emailCaptchar.setEmail("1227");
		emailCaptchar.setCreateTime(new Date(2017-06-15));
		
		emailCaptchaDao.saveCaptcha(emailCaptchar);*/
	}
}
