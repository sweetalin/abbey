package com.oeasy.service.impl;


import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.oeasy.baseTest.TestCase;
import com.oeasy.service.StudentService;

/**
 * 
 * @author alin
 *
 * 2017年6月13日
 */
public class TestStudentService extends TestCase {
    @Resource
    private StudentService studentService;
    Logger logger = Logger.getLogger(TestStudentService.class);

    @Test
    public void testSet() {
/*        Student student = new Student();
        student.setAvatar("avatar1");
        student.setName("黄渤");
        student.setType("配音演员");
        student.setIntroduction("中国内地男演员，毕业于北京电影学院表演系配音专业。黄渤早年曾有过驻唱歌手、舞蹈教练、影视配音等多种工作经历.");

        studentService.set(student);

        Student stu = (Student) studentService.get(student);
        System.out.println(stu);*/
    }
}