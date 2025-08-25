package com.example.demo13.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Enrollment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long enrollmentId;
	private String enrollStudentName;
	@Column(name="enroll_student_email",unique = true)
	private String enrollStudentEmail;
	@Column(name="enroll_student_phone",unique = true)
	private String enrollStudentPhone;
	
	
	@ManyToMany
	@JoinTable(name="enrollment_announcement", 
				joinColumns= @JoinColumn(name="enrollment_id"),
				inverseJoinColumns = @JoinColumn(name="announce_id",referencedColumnName = "announcement_id")
				)
	private List<Announcements> announcement;
	
	@OneToMany(mappedBy = "enrollment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EnrollmentAnnouncement> enrollmentAnnouncements ;

	public Enrollment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Enrollment(Long enrollmentId, String enrollStudentName, String enrollStudentEmail, String enrollStudentPhone, List<Announcements> announcement) {
		super();
		this.enrollmentId = enrollmentId;
		this.enrollStudentName = enrollStudentName;
		this.enrollStudentEmail = enrollStudentEmail;
		this.enrollStudentPhone = enrollStudentPhone;
		this.announcement = announcement;
	}

	public Long getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(Long enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public String getEnrollStudentName() {
		return enrollStudentName;
	}

	public void setEnrollStudentName(String enrollStudentName) {
		this.enrollStudentName = enrollStudentName;
	}

	public String getEnrollStudentEmail() {
		return enrollStudentEmail;
	}

	public void setEnrollStudentEmail(String enrollStudentEmail) {
		this.enrollStudentEmail = enrollStudentEmail;
	}

	public String getEnrollStudentPhone() {
		return enrollStudentPhone;
	}

	public void setEnrollStudentPhone(String enrollStudentPhone) {
		this.enrollStudentPhone = enrollStudentPhone;
	}

	public List<Announcements> getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(List<Announcements> announcement) {
		this.announcement = announcement;
	}

	public List<EnrollmentAnnouncement> getEnrollmentAnnouncements() {
		return enrollmentAnnouncements;
	}

	public void setEnrollmentAnnouncements(List<EnrollmentAnnouncement> enrollmentAnnouncements) {
		this.enrollmentAnnouncements = enrollmentAnnouncements;
	}

	
	
}
