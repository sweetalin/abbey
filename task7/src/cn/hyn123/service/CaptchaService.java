package cn.hyn123.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
  
public interface CaptchaService {

	/**
	 * 生成验证码
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void genernateCaptchaImage(HttpServletRequest request, HttpServletResponse response)  
            throws IOException;

}
