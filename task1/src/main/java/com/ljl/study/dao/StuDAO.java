package com.ljl.study.dao;

import java.util.List;

import com.ljl.study.entity.Stu;

/** 
* @author alin 
* @version 2017年6月7日
* 类说明 
*/
public interface StuDAO {
	public void insert(Stu stu) throws Exception;
    public void update(Stu stu) throws Exception;
    public void delete(int stuid) throws Exception;
    public Stu queryById(int stuid) throws Exception;
    public List<Stu> queryAll() throws Exception;
}
