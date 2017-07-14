package com.oeasy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oeasy.dao.StudentDao;
import com.oeasy.model.Student;
import com.oeasy.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDao studentDao;

	public Student select(Long id) {
		return studentDao.select(id);
	}

	public Integer insert(Student student) {
		return studentDao.insert(student);
	}

	public Integer update(Student student) {
		return studentDao.update(student);
	}

	public Integer delete(Long id) {
		return studentDao.delete(id);
	}

}
