package com.ljl.study.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ljl.study.pojo.Stu;
import com.ljl.study.service.StuService;


/**
 * @author alin
 * @version 2017年6月9日 类说明
 */
@Controller
@RequestMapping("/a")
public class StuController {
	private final static Logger logger = LoggerFactory.getLogger(StuController.class);

    @Autowired
    private StuService stuService;
    @Autowired
    private Stu stu;
    @RequestMapping(value = "/u/logout",method = RequestMethod.GET)
    public ModelAndView logout() {
    	ModelAndView mav = new ModelAndView();
    	List<Stu>  stu1 = stuService.list();
    	stu = stu1.get(1);
    	 logger.info("logout method start :");
         logger.info("StuId:{},StuName:{}", stu.getId(), stu.getName());
    	mav.addObject("stu", stu);
    	mav.setViewName("logout");
		return mav;
       
    }

	@RequestMapping(value = "/u/stu",method = RequestMethod.GET)
	public ModelAndView listCategory() {
		ModelAndView mav = new ModelAndView();
		List<Stu> ls = stuService.list();

		// 放入转发参数
		mav.addObject("ls", ls);
		// 放入jsp路径
		mav.setViewName("listStu");
		return mav;
	}

}