package com.example.demo13.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class AppUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long appUserId;
	
	@Column(unique = true)
	private String studentEmail;
	
	@Column(name="student_name")
	private String studentName;
	
	@Column(name="student_phone")
	private String StudentPhone;
	
	@Column(name="student_password")
	private String studentPassword;
	
	@OneToOne
	@JoinColumn(name="student_id",referencedColumnName = "studentId")
	private Student student;

	public AppUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppUser(long appUserId, String studentEmail, String studentName, String studentPhone, String studentPassword,
			Student student) {
		super();
		this.appUserId = appUserId;
		this.studentEmail = studentEmail;
		this.studentName = studentName;
		StudentPhone = studentPhone;
		this.studentPassword = studentPassword;
		this.student = student;
	}

	public long getAppUserId() {
		return appUserId;
	}

	public void setAppUserId(long appUserId) {
		this.appUserId = appUserId;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentPhone() {
		return StudentPhone;
	}

	public void setStudentPhone(String studentPhone) {
		StudentPhone = studentPhone;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
	
	
	
}
