package com.oeasy.service;

import com.oeasy.model.Student;

import java.util.List;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

/**
 * 
 * @author alin
 *
 * 2017年6月13日
 */
public interface StudentService {
    public List<Student> select();
}
