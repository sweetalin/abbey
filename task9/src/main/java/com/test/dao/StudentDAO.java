package com.test.dao;


public class StudentDAO extends BaseDAO {
	private static StudentDAO instance=null;
	public static StudentDAO getInstance(){
		return instance;
	}
	public StudentDAO(){
		instance=this;
	}
}