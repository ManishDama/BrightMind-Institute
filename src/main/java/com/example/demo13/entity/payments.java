package com.example.demo13.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
<<<<<<< HEAD
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
=======
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
>>>>>>> dev2
import jakarta.persistence.OneToOne;

@Entity
public class payments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String paymentId;
	private String paymentStatus;
	private LocalDateTime paymentDate;
	
<<<<<<< HEAD
	@OneToOne(mappedBy = "payment")
	private Student student;
=======
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="student_id")// <-- This is what you're asking about
	private Student student;
	
>>>>>>> dev2

	public payments() {
		super();
		// TODO Auto-generated constructor stub
	}

<<<<<<< HEAD
=======

>>>>>>> dev2
	public payments(long id, String paymentId, String paymentStatus, LocalDateTime paymentDate, Student student) {
		super();
		this.id = id;
		this.paymentId = paymentId;
		this.paymentStatus = paymentStatus;
		this.paymentDate = paymentDate;
		this.student = student;
	}

<<<<<<< HEAD
=======

>>>>>>> dev2
	public long getId() {
		return id;
	}

<<<<<<< HEAD
=======

>>>>>>> dev2
	public void setId(long id) {
		this.id = id;
	}

<<<<<<< HEAD
=======

>>>>>>> dev2
	public String getPaymentId() {
		return paymentId;
	}

<<<<<<< HEAD
=======

>>>>>>> dev2
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

<<<<<<< HEAD
=======

>>>>>>> dev2
	public String getPaymentStatus() {
		return paymentStatus;
	}

<<<<<<< HEAD
=======

>>>>>>> dev2
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

<<<<<<< HEAD
=======

>>>>>>> dev2
	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

<<<<<<< HEAD
=======

>>>>>>> dev2
	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

<<<<<<< HEAD
=======

>>>>>>> dev2
	public Student getStudent() {
		return student;
	}

<<<<<<< HEAD
	public void setStudent(Student student) {
		this.student = student;
	}
	
=======

	public void setStudent(Student student) {
		this.student = student;
	}



>>>>>>> dev2
	
	
}
