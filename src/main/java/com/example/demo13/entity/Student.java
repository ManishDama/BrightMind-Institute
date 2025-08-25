package com.example.demo13.entity;

import java.time.LocalDateTime;
<<<<<<< HEAD

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
=======
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
>>>>>>> dev2
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
<<<<<<< HEAD
import jakarta.persistence.ManyToOne;
=======
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
>>>>>>> dev2
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
	
<<<<<<< HEAD
	@ManyToOne
	@JoinColumn(name="app_user_id")
	private AppUser appUser;
	
	@ManyToOne
	@JoinColumn(name="announcement_id")
	private Announcements announcement;
	
	@OneToOne
	@JoinColumn(name="payment_id",referencedColumnName = "id")
	private payments payment;
=======
	
	
	
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
>>>>>>> dev2

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(long studentId, String studentName, String studentPhone, String studentEmail,
<<<<<<< HEAD
			LocalDateTime enrolledTime, AppUser appUser, Announcements announcement, payments payment) {
=======
			LocalDateTime enrolledTime, List<Announcements> announcement, List<payments> payment) {
>>>>>>> dev2
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentPhone = studentPhone;
		this.studentEmail = studentEmail;
		this.enrolledTime = enrolledTime;
<<<<<<< HEAD
		this.appUser = appUser;
=======
>>>>>>> dev2
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

<<<<<<< HEAD
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

=======
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
	
	
	

>>>>>>> dev2
	
}
