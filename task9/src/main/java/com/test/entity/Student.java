package com.test.entity;

import java.util.Date;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements
		java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String gender;
	private Date modified;
	private Date created;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** full constructor */
	public Student(String name, String gender, Date modified,
			Date created) {
		this.name = name;
		this.gender = gender;
		this.modified = modified;
		this.created = created;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getModified() {
		return this.modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}