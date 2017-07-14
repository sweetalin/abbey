package com.oeasy.service;

import com.oeasy.model.Student;

public interface StudentService {
	public Student select(Long id);
	public Integer insert(Student student);
	public Integer update(Student student);
	public Integer delete(Long id);
}
