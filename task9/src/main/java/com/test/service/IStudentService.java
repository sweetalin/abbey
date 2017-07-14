package com.test.service;
import java.util.List;

import org.osoa.sca.annotations.Remotable;

import com.test.entity.Student;

@Remotable
public interface IStudentService {
	List<Student> getAll();
}
