package com.example.demo13.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentId;
	
	private String studentName;
	private String studentPhone;
	private String studentEmail;
	private LocalDateTime enrolledTime;
	
	@ManyToOne
	@JoinColumn(name="app_user_id")
	private AppUser appUser;
	
	@ManyToOne
	@JoinColumn(name="announcement_id")
	private Announcements announcement;
	
	@OneToOne
	@JoinColumn(name="payment_id",referencedColumnName = "id")
	private payments payment;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(long studentId, String studentName, String studentPhone, String studentEmail,
			LocalDateTime enrolledTime, AppUser appUser, Announcements announcement, payments payment) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentPhone = studentPhone;
		this.studentEmail = studentEmail;
		this.enrolledTime = enrolledTime;
		this.appUser = appUser;
		this.announcement = announcement;
		this.payment = payment;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public LocalDateTime getEnrolledTime() {
		return enrolledTime;
	}

	public void setEnrolledTime(LocalDateTime enrolledTime) {
		this.enrolledTime = enrolledTime;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public Announcements getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(Announcements announcement) {
		this.announcement = announcement;
	}

	public payments getPayment() {
		return payment;
	}

	public void setPayment(payments payment) {
		this.payment = payment;
	}

	
}
