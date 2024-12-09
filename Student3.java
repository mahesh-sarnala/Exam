package com.klef.jfsd.HCQLOperations;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "HCQL_student_table")
public class Student3 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     private String name;
     private String gender;
     private String dept;
     
     private double cgpa;
     private int backlogs;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}

	public double getCgpa() {
		return cgpa;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	public int getBacklogs() {
		return backlogs;
	}
	public void setBacklogs(int backlogs) {
		this.backlogs = backlogs;
	}
     
     
}