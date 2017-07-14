package com.oeasy.dao;

import com.oeasy.model.Student;

import java.util.List;

/**
 * 
 * @author alin
 *
 * 2017年6月13日
 */
public interface StudentDao {
    public List<Student> select();
}
