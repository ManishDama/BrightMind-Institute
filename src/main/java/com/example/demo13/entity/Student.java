package com.example.demo13.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	
	
	
	
	@ManyToMany
	@JoinTable(name="student_announcement", 
				joinColumns= @JoinColumn(name="student_id"),
				inverseJoinColumns = @JoinColumn(name="announce_id",referencedColumnName = "announcement_id")
				)
	private List<Announcements> announcement;
//	@ManyToOne
//	@JoinColumn(name="announcement_id")
//	private Announcements announcement;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentAnnouncement> studentAnnouncements ;
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="student_id",referencedColumnName = "studentId")
	 private List<payments>  payment;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(long studentId, String studentName, String studentPhone, String studentEmail,
			LocalDateTime enrolledTime, List<Announcements> announcement, List<payments> payment) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentPhone = studentPhone;
		this.studentEmail = studentEmail;
		this.enrolledTime = enrolledTime;
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

	public List<Announcements> getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(List<Announcements> announcement) {
		this.announcement = announcement;
	}

	public List<payments> getPayment() {
		return payment;
	}

	public void setPayment(List<payments> payment) {
		this.payment = payment;
	}

	public List<StudentAnnouncement> getStudentAnnouncements() {
		return studentAnnouncements;
	}

	public void setStudentAnnouncements(List<StudentAnnouncement> studentAnnouncements) {
		this.studentAnnouncements = studentAnnouncements;
	}
	
	
	

	
}
