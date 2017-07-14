package com.oeasy.service.impl;

import com.oeasy.dao.StudentDao;
import com.oeasy.model.Student;
import com.oeasy.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * @author alin
 *
 * 2017Äê6ÔÂ11ÈÕ
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    public List<Student> select() {
        return studentDao.select();
    }
}
