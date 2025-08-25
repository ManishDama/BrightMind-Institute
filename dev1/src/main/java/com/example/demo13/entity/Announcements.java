package com.example.demo13.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Announcements {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="announcement_id")
	private long announcementId;
	private String announcingCourseTitle;
	private String description;
	private float price;
	@Column(name="course_start_date")
	private LocalDate batchStartDate;
	private String image;
	
	@ManyToMany(mappedBy = "announcement") // <-- This is what you're asking about
	private List<Enrollment> enrollments ;
	
	@ManyToOne(fetch = FetchType.EAGER) // <-- This is what you're asking about
	private Courses course ;
	
	@ManyToMany(mappedBy = "announcement") // <-- This is what you're asking about
	private List<Student> student ;
//	@ManyToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name="course_id",nullable=false)
//	private Courses course;
	

//	@OneToMany(mappedBy = "announcement", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<Enrollment> enrollments;
	
	
//	@OneToMany(mappedBy = "announcement", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<Student> students;
	public Announcements() {
		super();
		// TODO Auto-generated constructor stub
	}
public Announcements(long announcementId, String announcingCourseTitle, String description, float price,
		LocalDate batchStartDate, String image, List<Enrollment> enrollments, Courses course, List<Student> student) {
	super();
	this.announcementId = announcementId;
	this.announcingCourseTitle = announcingCourseTitle;
	this.description = description;
	this.price = price;
	this.batchStartDate = batchStartDate;
	this.image = image;
	this.enrollments = enrollments;
	this.course = course;
	this.student = student;
}
public long getAnnouncementId() {
	return announcementId;
}
public void setAnnouncementId(long announcementId) {
	this.announcementId = announcementId;
}
public String getAnnouncingCourseTitle() {
	return announcingCourseTitle;
}
public void setAnnouncingCourseTitle(String announcingCourseTitle) {
	this.announcingCourseTitle = announcingCourseTitle;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public LocalDate getBatchStartDate() {
	return batchStartDate;
}
public void setBatchStartDate(LocalDate batchStartDate) {
	this.batchStartDate = batchStartDate;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public List<Enrollment> getEnrollments() {
	return enrollments;
}
public void setEnrollments(List<Enrollment> enrollments) {
	this.enrollments = enrollments;
}
public Courses getCourse() {
	return course;
}
public void setCourse(Courses course) {
	this.course = course;
}
public List<Student> getStudent() {
	return student;
}
public void setStudent(List<Student> student) {
	this.student = student;
}
	

	
	
}
