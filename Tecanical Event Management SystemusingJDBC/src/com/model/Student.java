package com.model;

public class Student {
	private int studentid;
	private String stuname;
	private int age;
	private String stream;
	private String eventtype;
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public String getEventtype() {
		return eventtype;
	}
	public void setEventtype(String eventtype) {
		this.eventtype = eventtype;
	}
	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", stuname=" + stuname + ", age=" + age + ", stream=" + stream
				+ ", eventtype=" + eventtype + "]";
	}
	
	
	
	

	}