package com.ljl.study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljl.study.mapper.StuMapper;
import com.ljl.study.pojo.Stu;
import com.ljl.study.service.StuService;

/** 
* @author alin 
* @version 2017年6月9日
* 类说明 
*/
@Service
public class StuServiceImpl  implements StuService{
    @Autowired
    StuMapper stuMapper;
     
    public List<Stu> list(){
        return stuMapper.list();
    };
 
}