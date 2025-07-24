package com.example.demo13.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Enrollment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long enrollmentId;
	private String enrollStudentName;
	private String enrollStudentEmail;
	private String enrollStudentPhone;
	private String payment="unpaid";
	
	@ManyToOne
	@JoinColumn(name="announcemet_id")
	private Announcements announcement;

	public Enrollment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Enrollment(Long enrollmentId, String enrollStudentName, String enrollStudentEmail, String enrollStudentPhone,
			String payment, Announcements announcement) {
		super();
		this.enrollmentId = enrollmentId;
		this.enrollStudentName = enrollStudentName;
		this.enrollStudentEmail = enrollStudentEmail;
		this.enrollStudentPhone = enrollStudentPhone;
		this.payment = payment;
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

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public Announcements getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(Announcements announcement) {
		this.announcement = announcement;
	}

	@Override
	public String toString() {
		return "Enrollment [enrollmentId=" + enrollmentId + ", enrollStudentName=" + enrollStudentName
				+ ", enrollStudentEmail=" + enrollStudentEmail + ", enrollStudentPhone=" + enrollStudentPhone
				+ ", payment=" + payment + ", announcement=" + announcement + "]";
	}
	
	
}
