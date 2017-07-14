package cn.hyn123.service;

import org.springframework.stereotype.Component;

@Component
public interface EmailCaptchaService {
	/**
	 * 发送验证码
	 * @param email
	 * @param captcha
	 * @throws Exception 
	 */
	public void sendEmail(String email,String captcha) throws Exception;
	
	/**
	 * 检验邮箱验证码
	 * @param captcha
	 * @return
	 * @throws Exception
	 */
	public int checkEmailCaptcha(String email, String captcha) throws Exception;

}
