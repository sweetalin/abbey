
package com.oeasy.dao;

import com.oeasy.model.Student;

public interface StudentDao {
	public Student select(Long id);
	public Integer insert(Student student);
	public Integer update(Student student);
	public Integer delete(Long id);
}
