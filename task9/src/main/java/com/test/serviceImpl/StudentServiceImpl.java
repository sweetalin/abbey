package com.test.serviceImpl;

import java.util.List;

import com.test.dao.StudentDAO;
import com.test.entity.Student;
import com.test.service.IStudentService;

public class StudentServiceImpl implements IStudentService{
	private StudentDAO studentDao;
	public StudentServiceImpl(){
		studentDao=StudentDAO.getInstance();
	}
	@SuppressWarnings("unchecked")
	public List<Student> getAll(){
		return (List<Student>)studentDao.findAll(Student.class);
	}
}
