package com.ljl.study.mapper;

import java.util.List;

import com.ljl.study.pojo.Stu;

/** 
* @author alin 
* @version 2017年6月9日
* 类说明 
*/
public interface StuMapper {
	  
    public void add(Stu stu);  
        
    public void delete(int id);  
    
    public void update(Stu stu); 
        
    public Stu get(int id);  
      
    public List<Stu> list();
     
}