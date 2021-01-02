package com.ozeeesoftware.obsbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="mid_term")
	private int midTermExam;
	@Column(name="final")
	private int finalExam;
	@Column(name="GPA")
	private int gradePointAverage;
	
	public Student() {}

	public Student(int id, String firstName, String lastName, int midTermExam, int finalExam) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.midTermExam = midTermExam;
		this.finalExam = finalExam;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getMidTermExam() {
		return midTermExam;
	}

	public void setMidTermExam(int midTermExam) {
		this.midTermExam = midTermExam;
	}

	public int getFinalExam() {
		return finalExam;
	}

	public void setFinalExam(int finalExam) {
		this.finalExam = finalExam;
	}

	public int getGradePointAverage() {
		return gradePointAverage;
	}

	public void setGradePointAverage(int gradePointAverage) {
		this.gradePointAverage = gradePointAverage;
	}


	
	
	
}
