package com.oeasy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import com.oeasy.model.Student;
import com.oeasy.service.StudentService;

@Controller
@RequestMapping("/a")
public class StudentController {

//	@Autowired(required = true)
	private StudentService studentService1;
//	@Autowired(required = true)
	private StudentService studentService2;
	private ApplicationContext context = null;

	@ResponseBody
	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView,
			@PathVariable("id") Long id) {

		context = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		int flag = Math.random() > 0.5 ? 1 : 0;
		System.out.println("产生的随机数是：" + flag);
		Student student = null;
		try {
			switch (flag) {
			case 1:
				System.out.println("第一层访问service1");
				studentService1 = context.getBean("studentService1", StudentService.class);
				student = studentService1.select(id);
				break;
			default:
				System.out.println("第一层访问service2");
				studentService2 = context.getBean("studentService2", StudentService.class);
				student = studentService2.select(id);
				break;
			}
		} catch (Exception e1) {
			switch (flag) {
			case 1:
				System.out.println("第二层访问service2");
				studentService2 = context.getBean("studentService2", StudentService.class);
				student = studentService2.select(id);
				break;
			default:
				System.out.println("第二层访问service1");
				studentService1 = context.getBean("studentService1", StudentService.class);
				student = studentService1.select(id);
				break;
			}
		}

		modelAndView.addObject("student", student);
		modelAndView.setViewName("students");
		return modelAndView;
	}
}
