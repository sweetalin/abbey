package com.oeasy.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oeasy.model.Student;
import com.oeasy.service.StudentService;

public class StartServer {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:conf/spring-mybatis-server.xml");
		StudentService studentService = (StudentService) context.getBean("studentService");
		Student student = studentService.select(2l);
		System.out.println(student);
		System.out.println("发布成功");
	}
}
