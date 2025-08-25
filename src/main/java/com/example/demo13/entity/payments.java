package com.example.demo13.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class payments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String paymentId;
	private String paymentStatus;
	private LocalDateTime paymentDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="student_id")// <-- This is what you're asking about
	private Student student;
	

	public payments() {
		super();
		// TODO Auto-generated constructor stub
	}


	public payments(long id, String paymentId, String paymentStatus, LocalDateTime paymentDate, Student student) {
		super();
		this.id = id;
		this.paymentId = paymentId;
		this.paymentStatus = paymentStatus;
		this.paymentDate = paymentDate;
		this.student = student;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getPaymentId() {
		return paymentId;
	}


	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}


	public String getPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}



	
	
}
