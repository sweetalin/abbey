package com.oeasy.model;

/**
 * 
 * @author alin
 *
 * 2017年6月13日
 */
public class Student implements java.io.Serializable{
	static final long serialVersionUID = 42L;
    private long id;
    private String name;
    private String avatar;
    private String type;
    private String introduction;
    private long  schoolDay;
    
    public long getSchoolDay() {
		return schoolDay;
	}

	public void setSchoolDay(long schoolDay) {
		this.schoolDay = schoolDay;
	}

	public Student(long id, String name, String avatar, String type, String introduction) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.type = type;
        this.introduction = introduction;
    }

    public Student(long id, String name, String avatar, String type, String introduction, long schoolDay) {
		super();
		this.id = id;
		this.name = name;
		this.avatar = avatar;
		this.type = type;
		this.introduction = introduction;
		this.schoolDay = schoolDay;
	}

	public Student() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", type='" + type + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
