package com.ztech.dto;

public class Student {
	private int rollNo;
	private String name;
	private int marks;
	private int marksphy, markschem;
 
	public Student() {
		rollNo=marks=marksphy=markschem=0;
		name="";
	}
	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollno) {
		this.rollNo = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String student) {
		this.name = student;
	}

	public int getMarksPhy() {
		return marksphy;
	}

	public void setMarksPhy(int marks) {
		this.marksphy = marks;
	}
	public int getMarksChem() {
		return markschem;
	}

	public void setMarksChem(int marks) {
		this.markschem = marks;
	}
	
	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
}
