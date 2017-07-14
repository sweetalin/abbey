package com.ljl.study.entity;
/** 
* @author alin 
* @version 2017年6月7日
* 类说明 
*/
public class Stu {
private int id;
private String name;
private String type;
private long school_day;
private String gra_university;
private String day_report;
private String wish;
private String check_senior;
private long create_at;
private long update_id;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public long getSchool_day() {
	return school_day;
}
public void setSchool_day(long school_day) {
	this.school_day = school_day;
}
public String getGra_university() {
	return gra_university;
}
public void setGra_university(String gra_university) {
	this.gra_university = gra_university;
}
public String getDay_report() {
	return day_report;
}
public void setDay_report(String day_report) {
	this.day_report = day_report;
}
public String getWish() {
	return wish;
}
public void setWish(String wish) {
	this.wish = wish;
}
public String getCheck_senior() {
	return check_senior;
}
public void setCheck_senior(String check_senior) {
	this.check_senior = check_senior;
}
public long getCreate_at() {
	return create_at;
}
public void setCreate_at(long create_at) {
	this.create_at = create_at;
}
public long getUpdate_id() {
	return update_id;
}
public void setUpdate_id(long update_id) {
	this.update_id = update_id;
}
@Override
public String toString() {
	return "Stu [id=" + id + ", name=" + name + ", type=" + type + ", school_day=" + school_day + ", gra_university="
			+ gra_university + ", day_report=" + day_report + ", wish=" + wish + ", check_senior=" + check_senior + "]";
}

}
