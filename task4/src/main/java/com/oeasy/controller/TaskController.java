package com.oeasy.controller;

import com.oeasy.model.Student;
import com.oeasy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 
 * @author alin
 *
 * 2017Äê6ÔÂ11ÈÕ
 */
@Controller
@RequestMapping("/a")
public class TaskController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        List<Student> studentList = studentService.select();
        model.addAttribute("studentList", studentList);
        return "index";
    }

    @RequestMapping(value = "/occupation", method = RequestMethod.GET)
    public String occupation(Model model) {
        return "occupation";
    }
    @RequestMapping(value = "/date", method = RequestMethod.GET)
	public String testDate(Model model) {
		List<Student> studentList = studentService.select();
		model.addAttribute("studentList", studentList);
		return "date";
    }
}
