package com.oeasy.service.impl;

import com.oeasy.dao.StudentDao;
import com.oeasy.model.Student;
import com.oeasy.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * @author alin
 *
 * 2017年6月13日
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired(required=false) 
    private StudentDao studentDao;
	

    public List<Student> select() {
        return studentDao.select();
    }
}
