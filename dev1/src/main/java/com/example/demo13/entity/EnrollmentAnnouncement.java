package com.example.demo13.entity; // Adjust package as needed

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal; // Import for price
import java.time.LocalDateTime; // Optional: if you want to add a creation timestamp

@Entity
@Table(name = "enrollment_announcement") // Matches your database table name
public class EnrollmentAnnouncement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollment_announcement_id") // Matches your auto_increment PK column
    private Long id; // Use 'id' for the primary key

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "enrollment_id",referencedColumnName = "enrollmentId", nullable = false) // Matches your FK column name
    private Enrollment enrollment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "announce_id",referencedColumnName = "announcement_id", nullable = false) // Matches your FK column name
    private Announcements announcement; // Using 'Announcements' as per your entity name

    private String payment="unpaid";
    
    private LocalDateTime enrolledAt;


    // --- Constructors ---
    public EnrollmentAnnouncement() {
        // Set default creation time
    }

    // Constructor for creating new associations
    public EnrollmentAnnouncement(Enrollment enrollment, Announcements announcement) {
        this.enrollment = enrollment;
        this.announcement = announcement;
       
    }

    // --- Getters and Setters ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
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
