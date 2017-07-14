package com.oeasy.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oeasy.model.Student;
import com.oeasy.service.StudentService;

public class StudentServiceTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:client.xml");
		StudentService  studentService=(StudentService) applicationContext.getBean("studentService2");
		Student student = studentService.select(1l);
		System.out.println(student);
		System.out.println("远程访问成功");
	}
}
