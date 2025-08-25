package com.example.demo13.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="student_Announcement")
public class StudentAnnouncement {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_announcement_id") // Matches your auto_increment PK column
    private Long id; // Use 'id' for the primary key

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id", nullable = false) // Matches your FK column name
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "announce_id", nullable = false) // Matches your FK column name
    private Announcements announcement; // Using 'Announcements' as per your entity name

    
    private String payment;
    
    private LocalDateTime enrolledAt;
    
	public StudentAnnouncement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentAnnouncement(Long id, Student student, Announcements announcement) {
		super();
		this.id = id;
		this.student = student;
		this.announcement = announcement;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Announcements getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(Announcements announcement) {
		this.announcement = announcement;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public LocalDateTime getEnrolledAt() {
		return enrolledAt;
	}

	public void setEnrolledAt(LocalDateTime enrolledAt) {
		this.enrolledAt = enrolledAt;
	}

    

}
